package jp.IgatatApps.LostItemManager.model;

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
	public static String StrDatetimeNow() {
		Calendar cl = Calendar.getInstance();
		Date date = jp.IgatatApps.LostItemManager.model.CalendarDate.ParseCalendarToDate(cl);
		String str = jp.IgatatApps.LostItemManager.model.CalendarDate.ParseDateToString(date);
		return str;
	}
	public static String StrDatetimeDaysAgo(int day) {
		Calendar cl = Calendar.getInstance();
		cl.add(Calendar.DAY_OF_MONTH, -1*day);
		Date date = jp.IgatatApps.LostItemManager.model.CalendarDate.ParseCalendarToDate(cl);
		String str = jp.IgatatApps.LostItemManager.model.CalendarDate.ParseDateToString(date);
		return str;
	}
	public static Calendar ParseStrToCalendar(String str) {
		try{
			Date date = jp.IgatatApps.LostItemManager.model.CalendarDate.ParseStrToDate(str);
			Calendar cl = jp.IgatatApps.LostItemManager.model.CalendarDate.ParseDateToCalendar(date);
			return cl;
		}catch(Exception e ) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	public static String StrUnixtimeNow() {
		int int_unix = (int) (System.currentTimeMillis()/1000L);
		String str_unix = String.format("%010d", int_unix);
		System.out.println(str_unix);
		return str_unix;
	}
}