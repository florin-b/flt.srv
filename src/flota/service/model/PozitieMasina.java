package flota.service.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import flota.service.beans.PozitieAngajat;
import flota.service.beans.PozitieGps;
import flota.service.database.DBManager;
import flota.service.queries.SqlQueries;
import flota.service.utils.DateUtils;
import flota.service.utils.MailOperations;
import flota.service.utils.Utils;

public class PozitieMasina {

	private static final Logger logger = LogManager.getLogger(PozitieMasina.class);

	public List<PozitieAngajat> getPozitieAngajat(String angajati) {
		
		System.out.println("getPozitieAngajat: " + angajati);

		List<PozitieAngajat> listPozitii = new ArrayList<>();

		List<String> listAngajati = Arrays.asList(angajati.split(";"));

		OperatiiMasina masina = new OperatiiMasina();

		OperatiiAngajat opAngajat = new OperatiiAngajat();

		try (Connection conn = new DBManager().getProdDataSource().getConnection();) {
			for (String angajat : listAngajati) {

				String codGps = masina.getCodGps(conn, angajat, DateUtils.getFormattedCurrentDate());

				PozitieAngajat pozitie = new PozitieAngajat();
				pozitie.setNumeAngajat(opAngajat.getNumeAngajat(conn, angajat));
				pozitie.setPozitie(getCoordonateDisp(conn, codGps));
				listPozitii.add(pozitie);

			}
		} catch (SQLException e) {
			logger.error(Utils.getStackTrace(e));
		}

		return listPozitii;

	}

	public PozitieGps getCoordonateDisp(Connection conn, String codDisp) {

		PozitieGps pozitie = null;

		try (PreparedStatement stmt = conn.prepareStatement(SqlQueries.getPozitieMasina())) {

			stmt.setString(1, codDisp);
			stmt.setString(2, codDisp);

			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				pozitie = new PozitieGps();
				pozitie.setLatitudine(rs.getDouble("lat"));
				pozitie.setLongitudine(rs.getDouble("lon"));
				pozitie.setData(rs.getString("data"));
			}

		} catch (SQLException e) {
			logger.error(Utils.getStackTrace(e));
			MailOperations.sendMail(e.toString());
		}

		return pozitie;

	}

}
