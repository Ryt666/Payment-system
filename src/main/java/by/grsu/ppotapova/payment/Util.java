package by.grsu.ppotapova.payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public abstract class Util {
	
	public static Date getDateFromString(String dateStr) {
		try {
			return new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(dateStr).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
