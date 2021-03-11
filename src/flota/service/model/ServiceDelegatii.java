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

import flota.service.beans.AdresaOprire;
import flota.service.beans.DelegatieLite;
import flota.service.beans.IntervalData;
import flota.service.database.DBManager;
import flota.service.queries.SqlQueries;
import flota.service.utils.DateUtils;
import flota.service.utils.MailOperations;
import flota.service.utils.MapUtils;
import flota.service.utils.Utils;

public class ServiceDelegatii {

	private static final Logger logger = LogManager.getLogger(ServiceDelegatii.class);

	public void calculeazaKmSfarsitLuna() {

		List<DelegatieLite> listDelegatii = new ArrayList<>();

		IntervalData interval = DateUtils.getLastMonth();

		try (Connection conn = new DBManager().getProdDataSource().getConnection();
				PreparedStatement stmt = conn.prepareStatement(SqlQueries.getDelegatiiSfarsitLuna())) {

			stmt.clearParameters();

			stmt.setString(1, interval.getDataStart());
			stmt.setString(2, interval.getDataStop());
			stmt.setString(3, interval.getDataStop());

			stmt.executeQuery();

			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				DelegatieLite delegatie = new DelegatieLite();
				delegatie.setIdDelegatie(rs.getString("id"));
				delegatie.setCodAngajat(rs.getString("codAngajat"));
				delegatie.setNrMasina(rs.getString("nrAuto"));
				delegatie.setDataStart(rs.getString("data_plecare"));

				listDelegatii.add(delegatie);
			}

		} catch (SQLException e) {
			logger.error(Utils.getStackTrace(e));
			MailOperations.sendMail(Utils.getStackTrace(e));
		}

		calculeazaKmTeoretici(listDelegatii, interval);

	}

	public void calculeazaKmTeoretici(List<DelegatieLite> listDelegatii, IntervalData interval) {

		int distantaTeoretica = 0;

		try (Connection conn = new DBManager().getProdDataSource().getConnection();) {

			for (DelegatieLite delegatie : listDelegatii) {
				String dataStart = DateUtils.formatDateFromSap(delegatie.getDataStart()) + " " + "00:00";
				String dataStop = DateUtils.formatDateFromSap(interval.getDataStop()) + " " + "23:59";

				List<LatLng> coordonateOpriri = new OperatiiTraseu().getCoordOpririDelegatie(conn, delegatie.getIdDelegatie(), dataStart, dataStop);

				List<AdresaOprire> adreseOpriri = MapUtils.getAdreseCoordonate(coordonateOpriri);

				if (!adreseOpriri.isEmpty()) {
					distantaTeoretica = MapUtils.getDistantaTraseuCoordonate(adreseOpriri);
					setKmSfarsitLuna(conn, delegatie.getIdDelegatie(), distantaTeoretica);
				}

				System.out.println(delegatie.getIdDelegatie() + " , " + distantaTeoretica);

			}

		} catch (SQLException e) {
			logger.error(Utils.getStackTrace(e));
			MailOperations.sendMail(Utils.getStackTrace(e));
		}

	}

	public void setKmSfarsitLuna(Connection conn, String idDelegatie, int kmCalculati) {

		try (PreparedStatement stmt = conn.prepareStatement(SqlQueries.setKmSfarsitLuna())) {

			stmt.clearParameters();

			stmt.setDouble(1, kmCalculati);
			stmt.setString(2, idDelegatie);

			stmt.executeQuery();

		} catch (SQLException e) {
			logger.error(Utils.getStackTrace(e));
			MailOperations.sendMail(Utils.getStackTrace(e));
		}

	}

}
