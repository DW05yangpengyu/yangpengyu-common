package com.yangpengyu.common.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.yangpengyu.common.utils.DateUtils;

public class TestDate {

	@Test
	public void test1() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2000-09-06");
		//Date date = sdf.parse("2001-2-23");
		int age = DateUtils.getAge(date);
		System.out.println(age);
	}
	
	@Test
	public void test2() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2019-10-01");
		int days = DateUtils.getReminDays(date);
		System.out.println(days);
	}
	@Test
	public void test3() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2019-09-07");
		boolean days = DateUtils.isToday(date);
		System.out.println(days);
	}
	@Test
	public void test4() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2019-09-07");
		Date days = DateUtils.getMonthStart(date);
		System.out.println(days);
	}
	@Test
	public void test5() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2019-09-07");
		int days = DateUtils.dateCompareTo(date);
		System.out.println(days);
		String property = System.getProperty("user.name");
		System.out.println(property);
	}
	
	
	
	
	
	
	
	
	
	
	
}
