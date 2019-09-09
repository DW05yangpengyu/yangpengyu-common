package com.yangpengyu.common.test;

import org.junit.Test;

import com.yangpengyu.common.utils.Utils;

public class SecontTest {
	@Test
	public void test1(){
		StringBuilder html = Utils.toHtml("������\r���ף�˵�˷ż����ӷ��շ�\n\r����������\n\rsfsf");
		System.out.println(html);
	}
	@Test
	public void test2(){
		boolean istelephone = Utils.istelephone("17606141119");
		System.out.println(istelephone);
		boolean istelephone2 = Utils.istelephone("1766141119");
		System.out.println(istelephone2);
	}
	@Test
	public void test3(){
		boolean email = Utils.isEmail("yangpengyu@qq.com");
		System.out.println(email);
		boolean email2 = Utils.isEmail("yangpengyuqq.com");
		System.out.println(email2);
	}
}
