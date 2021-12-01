package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDate {
	
	public static Date ParseStrToDate(String str) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = dateFormat.parse(str);
		return date;
	}
	public static String ParseDateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = dateFormat.format(date);
		return str;
	}
	public static Calendar ParseDateToCalendar(Date date) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		return cl;
	}
	public static Date ParseCalendarToDate(Calendar cl) {
		Date date = cl.getTime();
		return date;
	}
	public static String DetermineFound_at(int int_found_at) {
		Calendar cl = Calendar.getInstance();
		cl.add(Calendar.DAY_OF_MONTH, -1*int_found_at);
		Date date = model.CalendarDate.ParseCalendarToDate(cl);
		String str = model.CalendarDate.ParseDateToString(date);
		return str;	
	}
	public static String DeterminePosted_at() {
		Calendar cl = Calendar.getInstance();
		Date date = model.CalendarDate.ParseCalendarToDate(cl);
		String str = model.CalendarDate.ParseDateToString(date);
		return str;
	}
}