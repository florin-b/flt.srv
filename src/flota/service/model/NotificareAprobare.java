package flota.service.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import flota.service.beans.FunctieConducere;
import flota.service.database.DBManager;
import flota.service.queries.SqlQueries;
import flota.service.utils.DateUtils;
import flota.service.utils.MailOperations;
import flota.service.utils.Utils;

public class NotificareAprobare {

	private static final Logger logger = LogManager.getLogger(NotificareAprobare.class);

	public static void main(String[] args) {
		new NotificareAprobare().getNotificariAprobari();

	}

	public void getNotificariAprobari() {

		List<FunctieConducere> listFunctii = getFunctiiConducere();

		StringBuilder strMail = new StringBuilder();

		for (FunctieConducere functie : listFunctii) {

			int nrDelegatiiAprobare = (new OperatiiDelegatii().getDelegatiiAprobari(functie.getFunctie(), functie.getFiliala(),
					functie.getDepartament() == null ? " " : functie.getDepartament())).size();

			if (nrDelegatiiAprobare > 0 && functie.getMail() != null) {

				strMail.append("Exista delegatii care asteapta aprobarea dumneavoastra.");

				strMail.append("\n");
				strMail.append("\n");
				strMail.append("Accesati aplicatia doar daca sunteti conectat la reteaua Arabesque de la aceasta adresa:");
				strMail.append("\n");
				strMail.append("https://delegatii.arabesque.ro");

				MailOperations.sendMailNotificare(functie.getMail(), strMail.toString());

				strMail.setLength(0);

			}

		}

	}

	private List<FunctieConducere> getFunctiiConducere() {
		List<FunctieConducere> listFunctii = new ArrayList<>();

		try (Connection conn = new DBManager().getProdDataSource().getConnection();
				PreparedStatement stmt = conn.prepareStatement(SqlQueries.getFunctiiConducere())) {

			stmt.executeQuery();

			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {

				FunctieConducere functie = new FunctieConducere();
				functie.setNumeAngajat(rs.getString("nume"));
				functie.setFiliala(rs.getString("filiala"));
				functie.setFunctie(rs.getString("functie"));
				functie.setDepartament(rs.getString("departament"));
				functie.setMail(rs.getString("mail"));
				listFunctii.add(functie);

			}

		} catch (SQLException e) {
			logger.error(Utils.getStackTrace(e));
		}

		return listFunctii;
	}

}
