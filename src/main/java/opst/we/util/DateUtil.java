/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * DateUtil.java
 */
package opst.we.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 隐藏构造器
	 */
	private DateUtil() {

	}

	/**
	 * 获得当前时间字符串，格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @return 系统时间字符串
	 */
	public static String getCurrentDateTime() {
		return DateFormat.formatDate(new Date(), DateFormat.FMT_DATE_YYYYMMDD_HHMMSS);
	}

	/**
	 * 获得当前的日期字符串，格式yyyy-MM-dd
	 * 
	 * @return 系统日期字符串
	 */
	public static String getCurrentDate() {
		return DateFormat.formatDate(new Date(), DateFormat.FMT_DATE_YYYYMMDD);
	}

	/**
	 * 获取当前Date
	 * 
	 * @return Date
	 */
	public static Date getCurrentTime() {
		return new Date();
	}

	/**
	 * 按指定的格式返回系统时间字符串
	 * 
	 * @param format
	 * @return
	 */
	public static String getDateTimeString(String format) {
		SimpleDateFormat fmtDate = new SimpleDateFormat(format);
		return fmtDate.format(new Date());
	}

	/**
	 * 求某个日期对应的字符串，格式yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return DateFormat.formatDate(date, DateFormat.FMT_DATE_YYYYMMDD);
	}

	/**
	 * 求某个日期时间字符串对应的时间，格式yyyy-MM-dd
	 * 
	 * @return
	 */
	public static Date stringToDate(String dateTimeStr) {
		if (StringUtils.isEmpty(dateTimeStr)) {
			return null;
		}
		try {
			SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return fmtDate.parse(dateTimeStr);
		} catch (Exception e) {
			try {
				SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
				return fmtDate.parse(dateTimeStr);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			return null;
		}
	}
	
	public static Date stringToDate(String dateTimeStr, String format) {
		try {
			SimpleDateFormat fmtDate = new SimpleDateFormat(format);
			return fmtDate.parse(dateTimeStr);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	/**
	 * 求某个日期时间对应的字符串，格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateTimeToString(Date date) {
		return DateFormat.formatDate(date, DateFormat.FMT_DATE_YYYYMMDD_HHMMSS);
	}

	/**
	 * 求某个日期往前或往后推算若干天得到的日期 如：2011-09-09,+1 ----->2011-09-10 2011-09-09,-1
	 * ----->2011-09-08
	 * 
	 * @param date
	 *            日期
	 * @param days
	 *            推算的天数
	 * @return 得到的日期
	 */
	public static Date addDate(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, days);
		return c.getTime();
	}
	
	public static Date addMonth(Date date, int m) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, m);
		return c.getTime();
	}
	
	/**
	 * 两个时间的天数查
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int daysBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 求某个日期是星期几 如： 2011-09-09---->1(星期一)
	 * 
	 * @param date
	 *            日期
	 * @return 星期
	 */
	public static int getDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (week == 0) {
			week = 7;
		}
		return week;
	}

	/**
	 * 求本周第一天的日期
	 * 
	 * @return
	 */
	public static Date getFirstDayThisWeek() {
		Date d = new Date();
		int week = getDayOfWeek(d);
		int add = 1 - week;
		return addDate(d, add);
	}

	/**
	 * 求本周最后一天的日期
	 * 
	 * @return
	 */
	public static Date getLastDayThisWeek() {
		Date d = new Date();
		int week = getDayOfWeek(d);
		int add = 7 - week;
		return addDate(d, add);
	}

	/**
	 * 求年份
	 * 
	 * @param date
	 *            日期
	 * @return 年份
	 */
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 判断是否为闰年
	 * 
	 * @param year
	 *            年份
	 * @return 是否为闰年
	 */
	public static boolean isLeapYear(int year) {
		return (year % 100 != 0 && year % 4 == 0) || year % 400 == 0;
	}

	/**
	 * 求月份
	 * 
	 * @param date
	 *            日期
	 * @return 月份
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		return month;
	}

	/**
	 * 求某个日期所在的月份的总天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getTotalDaysOfMonth(Date date) {
		int year = getYear(date);
		int month = getMonth(date);
		int days = 30;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			days = isLeapYear(year) ? 29 : 28;
			break;

		}
		return days;
	}

	/**
	 * 求某个日期是几号 如： 2011-09-09 ----->9 (9号)
	 * 
	 * @param date
	 *            日期
	 * @return 几号
	 */
	public static int getDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	/**
	 * 求某个日期所在月份的第一天
	 * 
	 * @return 所在月份的第一天
	 */
	public static Date getFirstDayThisMonth(Date d) {
		int day = getDayOfMonth(d);
		int add = 1 - day;
		return addDate(d, add);
	}


	/**
	 * 求某个日期所在月份的第一天
	 * 
	 * @return 所在月份的第一天
	 */
	public static Date getFirstDayThisMonth() {
		return getFirstDayThisMonth(new Date());
	}

	/**
	 * 求某个日期所在月份的最后一天
	 * 
	 * @return 所在月份的最后一天
	 */
	public static Date getLastDayThisMonth() {
		return getLastDayThisMonth(new Date());
	}
	
	/**
	 * 求某个日期所在月份的最后一天
	 * 
	 * @return 所在月份的最后一天
	 */
	public static Date getLastDayThisMonth(Date d) {
		int day = getDayOfMonth(d);
		int totalDays = getTotalDaysOfMonth(d);
		int add = totalDays - day;
		return addDate(d, add);
	}

	/**
	 * 求最近三个月的第一天 ,格式 yyyy-MM-dd
	 * 
	 * @return 最近三个月的第一天
	 */
	public static String getFirstDayInThreeMonth() {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.MONTH, -2);
		Date date = c.getTime();

		int year = getYear(date);
		int month = getMonth(date);

		StringBuffer sb = new StringBuffer();
		sb.append(year);
		sb.append("-");
		sb.append(month >= 10 ? month : "0" + month);
		sb.append("-01");
		return sb.toString();
	}

	/**
	 * 求下一天的日期字符串,格式yyyy-MM-dd
	 * 
	 * @return 下一天的日期字符串
	 */
	public static String getNextDay() {
		Date d = addDate(new Date(), 1);
		return dateToString(d);
	}

	/**
	 * 求上周今日字符串,格式yyyy-MM-dd
	 * 
	 * @return 上周今日的日期字符串
	 */
	public static String getLastWeekDay() {
		Date d = addDate(new Date(), -7);
		return dateToString(d);
	}

	/**
	 * 求最近30天的日期字符串,格式yyyy-MM-dd
	 * 
	 * @return 最近30天的日期字符串
	 */
	public static String getLastMonthDay() {
		Date d = addDate(new Date(), -30);
		return dateToString(d);
	}

	/**
	 * 求本月第一日字符串,格式yyyy-MM-dd
	 * 
	 * @return 本月第一日的日期字符串
	 */
	public static String getMonthDay() {
		Date date = new Date();
		int year = getYear(date);
		int month = getMonth(date);

		StringBuffer sb = new StringBuffer();
		sb.append(year);
		sb.append("-");
		sb.append(month >= 10 ? month : "0" + month);
		sb.append("-01");
		return sb.toString();
	}

	/**
	 * 求当天零点
	 * 
	 * @return
	 */
	public static Date getToday() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获取当前日期，指定格式延期N
	 * @param addType
	 * @param val
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static Date getDate(int addType, int val) {
		Calendar now = Calendar.getInstance();
		now.add(addType, val);
		return now.getTime();
	}

	public static void main(String[] args) {
		System.out.println(dateTimeToString(addMonth(new Date(), 1)));
	}

	/**
	 * @return x-x-(x + lastday) 23:59:59
	 * @param afterday
	 */
	public static Date getLastDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	public static Date setDate(Date date, int addType, int val) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(addType, val);
		return calendar.getTime();
	}
	
	/**
	 * 得到日期 00:00:00
	 * @param date yyyy-MM-dd
	 * @return yyyy-MM-dd 00:00:00
	 */
	public static String getDateZero(String date){
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(fmtDate.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return dateTimeToString(calendar.getTime());
	}
	/**
	 * 得到日期 23:59:59
	 * @param date
	 * @return yyyy-MM-dd 23:59:59
	 */
	public static String getDateClock(String date){
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		Date dates = null;
		try {
			dates = getLastDate(fmtDate.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTimeToString(dates);
	}
	
	/**
	 * 验证输入的文本信息日期是否合法
	 * 
	 * @param inputDate
	 * @return
	 */
	public static Date isDate(String dateStr) {
		String date_format_1 = "yyyy/MM/dd";
		String date_format_2 = "yyyy-MM-dd";
		String date_format_3 = "yyyyMMdd";
		String date_format_4 = "yyyy.MM.dd";
		String[] date_format = { date_format_1, date_format_2, date_format_3, date_format_4 };
		for (int i = 0; i < date_format.length; i++) {
			try {
				SimpleDateFormat formatDate = new SimpleDateFormat(date_format[i]);
				formatDate.setLenient(false);
				ParsePosition pos = new java.text.ParsePosition(0);
				Date tempDate = formatDate.parse(dateStr, pos);
				tempDate.getTime();
				return tempDate;
			} catch (Exception e) {
			}
		}
		return null;
	}

	/**
	 * 方法 getAfterDate 得到与指定日期相差指定天数的日期
	 * 
	 * @param baseDate
	 *            时间字符串，如：2001-07-17 11:00:00
	 * @param dayCount
	 *            向前或向后的天数，向后为正数，向前为负值
	 * @return 处理后的日期字符串
	 */
	public static String getAfterDate(String baseDate, int dayCount) {
		int year = Integer.parseInt(baseDate.substring(0, 4));
		int month = Integer.parseInt(baseDate.substring(5, 7));
		int date = Integer.parseInt(baseDate.substring(8, 10));

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date);
		calendar.add(Calendar.DATE, dayCount);
		Date _date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(_date);

		return dateString;
	}

	public static String getAfterDate(String baseDate, int dayCount, String patternString) {
		int year = Integer.parseInt(baseDate.substring(0, 4));
		int month = Integer.parseInt(baseDate.substring(5, 7));
		int date = Integer.parseInt(baseDate.substring(8, 10));

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date);
		calendar.add(Calendar.DATE, dayCount);
		Date _date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(patternString);
		String dateString = formatter.format(_date);

		return dateString;
	}

	public static Object getStrDate(String dateStr, String patten) {
		SimpleDateFormat formatter = new SimpleDateFormat(patten);
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
		}
		return null;
	}
}
