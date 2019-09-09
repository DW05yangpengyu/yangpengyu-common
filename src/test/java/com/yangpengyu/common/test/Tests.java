package com.yangpengyu.common.test;

import org.junit.Test;

import com.yangpengyu.common.utils.Utils;

public class Tests {
	@Test
	public void test1(){
		boolean empty = Utils.isEmpty("q");
		System.out.println(empty);
	}
	@Test
	public void test2(){
		boolean b = Utils.istelephone("17606141119");
		System.out.println(b);
	}
	@Test
	public void test3(){
		boolean b = Utils.isEmail("yangpengyu@cn.com");
		System.out.println(b);
	}
	@Test
	public void test4(){
		 String str = Utils.randomLeterStr(11);
		System.out.println(str);
	}
	
	@Test
	public void test5(){
		 String str = Utils.randomstr(12);
		System.out.println(str);
	}
	@Test
	public void test6(){
		 String str = Utils.getOnCn();
		System.out.println(str);
	}
	@Test
	public void test7(){
		 String str = Utils.getRandonCnStr(5);
		System.out.println(str);
	}
}
