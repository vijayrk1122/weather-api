package com.assignments.utils;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author vijay.kumbhakarna
 *
 */
public class DateUtils {

	public static String nextDayOfWeek() {		
		String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday" };
		Calendar cal = Calendar.getInstance();
		return strDays[cal.get(Calendar.DAY_OF_WEEK)];
	}
	
	public static String getCurrentTimestampInString() {
		return new Timestamp(Calendar.getInstance().getTime().getTime())+"";
	}

}
