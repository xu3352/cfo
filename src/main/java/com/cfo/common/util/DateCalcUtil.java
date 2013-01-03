package com.cfo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期Util
 * @author xuyinglong
 * @date   2012-12-5
 */
public class DateCalcUtil {

	/**
	 * 字符串日期转Date
	 * @param date yyyy-MM-dd
	 * @return 日期
	 * @throws ParseException
	 * @author xuyl
	 */
	public static Date dateParse(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
		return format.parse(date);
	}
	
	/**
	 * 格式化日期
	 * @param date yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 * @author xuyl
	 */
	public static String dateFormat(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
		return format.format(date);
	}
	
	/**
	 * 日期加减
	 * @param dateStr yyyy-MM-dd
	 * @param amount 数值
	 * @return dateStr+? yyyy-MM-dd
	 * @throws ParseException
	 * @author xuyl
	 */
	public static String dateAdd(String dateStr, int amount) throws ParseException {
		return dateAdd(dateStr, Calendar.DATE, amount);
	}
	
	/**
	 * 日期加减
	 * @param dateStr yyyy-MM-dd
	 * @param field Calendar.DATE...
	 * @param amount 数值
	 * @return dateStr+? yyyy-MM-dd
	 * @throws ParseException
	 * @author xuyl
	 */
	public static String dateAdd(String dateStr, int field, int amount) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateParse(dateStr));
		cal.add(field, amount);
		return dateFormat(cal.getTime());
	}
	
	/**
	 * 日期设置
	 * @param dateStr yyyy-MM-dd
	 * @param field Calendar.DAY_OF_WEEK...
	 * @param value Calendar.MONDAY...
	 * @return dateStr+? yyyy-MM-dd
	 * @throws ParseException
	 * @author xuyl
	 */
	public static String dateSet(String dateStr, int field, int value) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateParse(dateStr));
		cal.set(field, value);
		return dateFormat(cal.getTime());
	}
	
	/**
	 * 今天的日期
	 * @return 
	 * @author xuyl
	 */
	public static String getNow() {
		return dateFormat(Calendar.getInstance().getTime());
	}
	
	/**
	 * 昨天的日期
	 * @return 
	 * @author xuyl
	 * @throws ParseException 
	 */
	public static String getYesterday() throws ParseException {
		return dateAdd(getNow(), -1);
	}
	
	/**
	 * 指定日期的周一
	 * @param date
	 * @return
	 * @author xuyl
	 * @throws ParseException 
	 */
	public static String getMonday(String date) throws ParseException {
		return dateSet(date, Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	}
	
	/**
	 * 指定日期的上周周一
	 * @param date
	 * @return
	 * @author xuyl
	 * @throws ParseException 
	 */
	public static String getLastMonday(String date) throws ParseException {
		return dateSet(dateAdd(date, -7), Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	}
	
	/**
	 * 指定日期的上周周日:老外的周日是一周的第一天哦
	 * @param date
	 * @return
	 * @author xuyl
	 * @throws ParseException 
	 */
	public static String getSunday(String date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateParse(date));
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)	return date;	// 周日直接返回
		return dateSet(dateAdd(date, 7), Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	}
	
	/**
	 * 指定日期的上周周日:老外的周日是一周的第一天哦
	 * @param date
	 * @return
	 * @author xuyl
	 * @throws ParseException 
	 */
	public static String getLastSunday(String date) throws ParseException {
		return getSunday(dateAdd(date, -7));
	}
	
	/**
	 * 指定日期的当前月1号
	 * @param date
	 * @return
	 * @author xuyl
	 * @throws ParseException 
	 */
	public static String getFirstDayOfMonth(String date) throws ParseException {
		return dateSet(date, Calendar.DAY_OF_MONTH, 1);
	}
	
	/**
	 * 获取本周是该年的第几周<br/>
	 * 1号所在的周为第一周算起
	 * @return
	 * @author xuyl
	 * @throws ParseException 
	 */
	public static int getWeekOfYear(String date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(7);
		cal.setTime(dateParse(date));
		return cal.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * 获取去年同自然周的周一
	 * @param date
	 * @return
	 * @throws ParseException
	 * @author xuyl
	 */
	public static String getLastYearByWeekMonday(String date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(7);
		cal.setTime(dateParse(date));
		cal.set(cal.get(Calendar.YEAR) - 1, Calendar.JANUARY, 1);
		cal.add(Calendar.WEEK_OF_YEAR, getWeekOfYear(date));
		return getMonday(dateFormat(cal.getTime()));
	}
	
	public static void main(String[] args) throws ParseException {
//		System.out.println(dateAdd("2012-12-03", -1));
//		System.out.println(getLastMonday("2012-12-03"));
//		System.out.println(getLastSunday("2012-12-03"));
//		System.out.println(getFirstDayOfMonth("2012-11-25"));
		System.out.println(getSunday("2012-12-05"));
		System.out.println(getLastYearByWeekMonday("2012-12-05"));
	}
}
