package com.yangpengyu.common.test;

import java.util.List;

import org.junit.Test;

import com.yangpengyu.common.utils.FileUtils;

public class Testfile {
	@Test
	public void test1(){
		FileUtils.delFilePath("D:\\Office14 - ¸±±¾");
	}
	
	@Test
	public void test2() throws Exception{
		String fileName = "E:\\xiao1\\yangpengyu-common\\src\\main\\resources\\reginfo";
		List list= FileUtils.filToBean(fileName,RegisterInto.class.getConstructor(
				String.class,String.class,String.class,String.class,String.class,
				String.class,String.class,String.class,String.class,String.class
				
				) );
		
		for (Object object : list) {
			System.out.println(object);
		}
	}
}
