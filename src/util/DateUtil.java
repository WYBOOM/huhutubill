package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sun.util.resources.CalendarData;

public class DateUtil {
	public static long millisecondsOfDay=1000 * 60*60*24;
	
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	public static Date today(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		return c.getTime();
	}
	
	public static Date monthBegin(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE,1);
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	public static Date monthEnd(){
		Calendar c= Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND, 0);
		
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);
		
		return c.getTime();
		
	}
	public static int thisMonthTotalDay(){
		long lastDayMilliSeconds= monthEnd().getTime();
		long firstDayMilliSeconds = monthBegin().getTime();
		return (int) ((lastDayMilliSeconds -firstDayMilliSeconds)/millisecondsOfDay)+1;
	}
	
	public static int thisMonthLeftDay(){
        long lastDayMilliSeconds = monthEnd().getTime();
        long toDayMilliSeconds = today().getTime();
        return (int) ((lastDayMilliSeconds-toDayMilliSeconds)/millisecondsOfDay)+1;
    }  
	public static void main(String[] args) {
		System.out.println(monthEnd());
	}
	public static String date2string(Date date){
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        return sdf.format(date);
	    }
	     
	    public static Date string2date(String s){
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = null;
	        try {
	            date = sdf.parse(s);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return date;
	    }
}
