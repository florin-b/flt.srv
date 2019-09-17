package flota.service.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {

		int lYear = Calendar.getInstance().get(Calendar.YEAR);

		int fYear = 2012;

		int nrYears = lYear - fYear;

		System.out.println(nrYears);

		List<String> years = new ArrayList<String>();

		for (int i = 0; i <= nrYears; i++) {
			years.add(String.valueOf(fYear + i));
		}

		System.out.println(years);

		String[] arr = years.toArray(new String[0]);

		System.out.println(arr[0]);

	}

}
