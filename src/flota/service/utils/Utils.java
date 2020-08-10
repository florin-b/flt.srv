package flota.service.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Utils {

	public static String getStackTrace(Exception ex) {
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}

	public static synchronized String getId() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String dateInString = "01-01-2017";
		Date date;
		Calendar calendar = Calendar.getInstance();

		try {
			date = sdf.parse(dateInString);
			calendar.setTime(date);

		} catch (ParseException e) {

		}

		long millis = System.currentTimeMillis() - calendar.getTimeInMillis();
		return (String.valueOf(millis));
	}

	public static String getUnitLog(String numeFiliala) {
		String fl = "NN10";

		if (numeFiliala.equals("BACAU"))
			fl = "BC10";

		else if (numeFiliala.equals("BUZAU"))
			fl = "BZ10";

		else if (numeFiliala.equals("GALATI"))
			fl = "GL10";

		else if (numeFiliala.equals("PITESTI"))
			fl = "AG10";

		else if (numeFiliala.equals("TIMISOARA"))
			fl = "TM10";

		else if (numeFiliala.equals("ORADEA"))
			fl = "BH10";

		else if (numeFiliala.equals("FOCSANI"))
			fl = "VN10";

		else if (numeFiliala.equals("GLINA"))
			fl = "BU10";

		else if (numeFiliala.equals("ANDRONACHE"))
			fl = "BU13";

		else if (numeFiliala.equals("OTOPENI"))
			fl = "BU12";

		else if (numeFiliala.equals("CLUJ"))
			fl = "CJ10";

		else if (numeFiliala.equals("BAIA"))
			fl = "MM10";

		else if (numeFiliala.equals("MILITARI"))
			fl = "BU11";

		else if (numeFiliala.equals("CONSTANTA"))
			fl = "CT10";

		else if (numeFiliala.equals("BRASOV"))
			fl = "BV10";

		else if (numeFiliala.equals("PLOIESTI"))
			fl = "PH10";

		else if (numeFiliala.equals("PIATRA"))
			fl = "NT10";

		else if (numeFiliala.equals("MURES"))
			fl = "MS10";

		else if (numeFiliala.equals("IASI"))
			fl = "IS10";

		else if (numeFiliala.equals("CRAIOVA"))
			fl = "DJ10";

		else if (numeFiliala.equals("SIBIU"))
			fl = "SB10";

		else if (numeFiliala.equals("DEVA"))
			fl = "HD10";

		return fl;

	}

	public static boolean isAngajatVanzari(String tipAngajat) {

		boolean isVanzari;

		switch (tipAngajat) {
		case "AV":
		case "SD":
		case "KA":
		case "CV":
		case "DV":
		case "DD":
		case "SMG":
		case "SMR":
		case "SMW":
		case "SDIP":
			isVanzari = true;
			break;
		default:
			isVanzari = false;
			break;
		}

		return isVanzari;

	}

	public static String flattenToAscii(String string) {
		StringBuilder sb = new StringBuilder(string.length());
		String localString = Normalizer.normalize(string, Normalizer.Form.NFD);
		for (char c : localString.toCharArray()) {
			if (c <= '\u007F')
				sb.append(c);
		}
		return sb.toString();
	}

	public static String getTipSubordonat(String tipSuperior) {

		if (tipSuperior.equals("SDKA"))
			return "KA";

		return tipSuperior;

	}

	public static String generateQs(String strValues) {
		StringBuilder items = new StringBuilder("(");

		String[] arrayValues = strValues.split(",");

		for (int i = 0; i < arrayValues.length; i++) {
			if (i != 0)
				items.append(", ");
			items.append("?");
		}

		items.append(")");

		return items.toString();
	}

}
