package net.vicp.hrghope.warehouse.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static Date getDayBegin(Date date) {
		if(date==null){
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	public static Date getDayEnd(Date date) {
		if(date==null){
			return null;
		}
		Date dayBegin = getDayBegin(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dayBegin);

		cal.add(Calendar.DATE, 1);
		cal.add(Calendar.MILLISECOND, -1);
		return cal.getTime();
	}
}
