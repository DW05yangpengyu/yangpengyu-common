package com.yangpengyu.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	/**
	 * //由出生日期获得年龄  
	 * @param birthday
	 * @return
	 */
	public static int getAge(Date birthday){
		//得到出生的年月日
		Calendar instance = Calendar.getInstance();
		instance.setTime(birthday);
		int i1 = instance.get(Calendar.YEAR);
		int i2 = instance.get(Calendar.MONTH);
		int i3 = instance.get(Calendar.DAY_OF_MONTH);
		//得到现在的年月日
		instance.setTime(new Date());
		int b1 = instance.get(Calendar.YEAR);
		int b2 = instance.get(Calendar.MONTH);
		int b3 = instance.get(Calendar.DAY_OF_MONTH);
		int age = b1-i1;
		if (b2<i2) {
			age--;
		}else if (b2==i2 && b3<i3) {
			age--;
		}
		return age;
	}
	
	/**
	 * 剩余天数
	 */
	public static int getReminDays(Date futureDate){
		return (int)(futureDate.getTime()-new Date().getTime())/1000/3600/24;
	}
	
	/**
	 * 3.4.4判断是否为当天
	 */
	public static boolean isToday(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(sdf.format(date).toString().equals(sdf.format(new Date()).toString())){
			System.out.println(sdf.format(date).toString());
			System.out.println(sdf.format(new Date()).toString());
			return true;
		}else{
			return false;
		}
		/*Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		cal.setTime(new Date());
		int nowyear = cal.get(Calendar.YEAR);
		int nowmonth = cal.get(Calendar.MONTH);
		int nowday = cal.get(Calendar.DAY_OF_MONTH);
		if(year==nowyear){
			if(month==nowmonth){
				if(day==nowday){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}*/
	}
	
	public static boolean isThisWeek(Date date) {
		
	    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());
	    firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
	    int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);
	    firstDayOfWeek.add(Calendar.DATE, -day+1+1);// 后面的+1是因为从周日开始
	    // 本周一的日期
	    System.out.println(format.format(firstDayOfWeek.getTime()));
	     
	    Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());
	    lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
	    day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);
	    lastDayOfWeek.add(Calendar.DATE, 7-day+1);
	    // 本周星期天的日期
	    System.out.println(format.format(lastDayOfWeek.getTime()));
	    
	    return (date.getTime()<lastDayOfWeek.getTime().getTime() && date.getTime()>firstDayOfWeek.getTime().getTime() );
	}
	public static boolean isCurrentMonth(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	/**
	 * 给定时间对象，初始化到该月末的最后一秒  比如 2019/11/30 23:59:59 
	 * @param date
	 * @return
	 */
	public static Date getMonthEnd(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime(); 
	}
	/**
	 * 3.4.7给定时间对象，初始化到该月初的1月1日0时0分0秒0毫秒
	 */
	public static Date getMonthStart(Date src){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		//calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		//calendar.add(Calendar.SECOND, 1);
		return calendar.getTime(); 
	}
	/*
	 * 3.4.9时间比较
	 */
	public static int dateCompareTo(Date date) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = sdf.parse("2018-09-07");
		return date.compareTo(date2);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
