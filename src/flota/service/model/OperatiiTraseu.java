package flota.service.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.maps.model.LatLng;

import flota.service.beans.BeanDelegatieCauta;
import flota.service.beans.PunctTraseu;
import flota.service.database.DBManager;

import flota.service.queries.SqlQueries;
import flota.service.utils.MapUtils;
import flota.service.utils.Utils;

public class OperatiiTraseu {

	private static final Logger logger = LogManager.getLogger(OperatiiTraseu.class);

	private static final double razaKmSosire = 10;

	public List<String> getCoordonateTraseu(String idDelegatie) {

		List<String> listCoords = new ArrayList<>();

		try (Connection conn = DBManager.getProdInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(SqlQueries.getCoordonateTraseu(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {

			String codDisp = new OperatiiMasina().getCodDispGps(idDelegatie);
			BeanDelegatieCauta delegatie = new OperatiiDelegatii().getDelegatie(idDelegatie);

			String dataPlecare = delegatie.getDataPlecare() + " " + delegatie.getOraPlecare().substring(0, 2) + ":" + delegatie.getOraPlecare().substring(2, 4);

			String dataSosire = delegatie.getDataSosire() + " " + "23:59";

			stmt.setString(1, codDisp);

			stmt.setString(2, dataPlecare);
			stmt.setString(3, dataSosire);

			stmt.executeQuery();

			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {

				listCoords.add(rs.getString("lat") + ":" + rs.getString("lon"));

			}

		} catch (SQLException e) {
			logger.error(Utils.getStackTrace(e));
		}

		return listCoords;

	}

	public static String getDateSosireTraseu(String idDelegatie) {

		double startKm = 0;
		double stopKm = 0;
		String oraSosire = null;

		List<PunctTraseu> objPuncte = null;
		BeanDelegatieCauta delegatie = null;

		try (Connection conn = DBManager.getProdInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(SqlQueries.getCoordonateTraseu(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {

			String codDisp = new OperatiiMasina().getCodDispGps(idDelegatie);
			delegatie = new OperatiiDelegatii().getDelegatie(idDelegatie);
			delegatie.setId(idDelegatie);

			String dataPlecare = delegatie.getDataPlecare() + " " + delegatie.getOraPlecare().substring(0, 2) + ":" + delegatie.getOraPlecare().substring(2, 4);

			String dataSosire = delegatie.getDataSosire() + " " + "23:59";

			stmt.setString(1, codDisp);

			stmt.setString(2, dataPlecare);
			stmt.setString(3, dataSosire);

			stmt.executeQuery();

			ResultSet rs = stmt.getResultSet();

			objPuncte = new OperatiiDelegatii().getPuncteTraseu(DBManager.getTestInstance().getConnection(), idDelegatie);

			LatLng coordStop = objPuncte.get(objPuncte.size() - 1).getCoordonate();

			int i = 0;
			boolean startDel = false;
			while (rs.next()) {

				if (i == 0)
					startKm = rs.getDouble("km");

				stopKm = rs.getDouble("km");

				double distSosire = MapUtils.distanceXtoY(coordStop.lat, coordStop.lng, Double.parseDouble(rs.getString("lat")), Double.parseDouble(rs.getString("lon")), "K");

				if (distSosire > razaKmSosire)
					startDel = true;

				for (int jj = 0; jj < objPuncte.size() - 1; jj++) {
					if (!objPuncte.get(jj).isVizitat()) {
						double distPunct = MapUtils.distanceXtoY(objPuncte.get(jj).getCoordonate().lat, objPuncte.get(jj).getCoordonate().lng,
								Double.parseDouble(rs.getString("lat")), Double.parseDouble(rs.getString("lon")), "K");

						if (distPunct < razaKmSosire) {
							objPuncte.get(jj).setVizitat(true);
							break;
						}
					}

				}

				if (distSosire < razaKmSosire && startDel) {
					stopKm = rs.getDouble("km");
					oraSosire = rs.getString("gtime").replace(":", "");
					objPuncte.get(objPuncte.size() - 1).setVizitat(true);
					break;
				} else {
					i++;
				}

			}

		} catch (SQLException e) {
			logger.error(Utils.getStackTrace(e));
		}

		if ((stopKm - startKm) > 0)
			try {
				actualizeazaSosireDelegatie(delegatie, oraSosire, stopKm - startKm, objPuncte);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return "!";
	}

	public static void actualizeazaSosireDelegatie(BeanDelegatieCauta delegatie, String oraSosire, double distReal, List<PunctTraseu> puncte) throws SQLException {

		try (Connection conn = DBManager.getTestInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(SqlQueries.setSfarsitDelegatie());) {

			stmt.setString(1, oraSosire);
			stmt.setDouble(2, (int) distReal);
			stmt.setString(3, delegatie.getId());

			stmt.executeQuery();

			for (PunctTraseu punct : puncte) {

				PreparedStatement stmt1 = conn.prepareStatement(SqlQueries.updatePuncte());
				stmt1.setString(1, punct.isVizitat() ? "1" : "0");
				stmt1.setString(2, delegatie.getId());
				stmt1.setString(3, String.valueOf(punct.getPozitie() + 1));

				stmt1.executeQuery();

				stmt1.close();
				stmt1 = null;

			}

			verificaAprobAutomat(delegatie, distReal, puncte);

		}

	}

	public static void verificaAprobAutomat(BeanDelegatieCauta delegatie, double distReal, List<PunctTraseu> puncte) {

		try {
			int kmCota = new OperatiiAngajat().getKmCota(DBManager.getTestInstance().getConnection(), delegatie.getAngajatId(), delegatie.getDataPlecare(),
					delegatie.getDataSosire());

			if (distReal > (delegatie.getDistantaCalculata() + kmCota))
				return;

			for (PunctTraseu punct : puncte)
				if (!punct.isVizitat())
					return;

			new OperatiiDelegatii().aprobaAutomatDelegatie(delegatie.getId());

		} catch (SQLException e) {

			logger.error(Utils.getStackTrace(e));
		}

	}

}
