package com.yangpengyu.common.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	/**
	 * 判断是否为空
	 */
	public static boolean isEmpty(String str) {
		// return (null==str||"".equals(str.trim()));
		return (null != str && str.trim().length() > 0);
	}

	/**
	 * 验证手机号码
	 */
	public static boolean istelephone(String str) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		boolean b = matcher.matches();
		return b;
	}

	/**
	 * 验证邮箱
	 */
	public static boolean isEmail(String str) {
		String regex = "^[a-z0-9A-z]{2,}@[a-z0-9A-z]{1,}\\.[a-zA-z]{2,}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		boolean b = matcher.matches();
		return b;
	}

	/**
	 * 获取n位随机英文字符串
	 */
	public static String randomLeterStr(int n) {
		if (n <= 0) {
			return "";
		}
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			char letter = (char) ('A' + random.nextInt(26));
			sb.append(letter);
		}
		return sb.toString();
	}

	/**
	 * 获取n位英文和数字字符串
	 */
	public static String randomstr(int n) {
		char chars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				'N', 'O', 'P', 'Q', 'r', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z', 'a', 's', 'd', 'f', 'g', 'h' };

		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int int1 = random.nextInt(chars.length);
			char c = chars[int1];
			sb.append(c);
		}
		return sb.toString();

	}

	/**
	 * 随机获取1个中文字符串
	 */
	public static String getOnCn() {
		String str = "";
		int hightPos;
		int lowPos;
		Random random = new Random();

		hightPos = (176 + Math.abs(random.nextInt(39)));
		lowPos = (161 + Math.abs(random.nextInt(93)));

		byte[] b = new byte[2];
		b[0] = (Integer.valueOf(hightPos)).byteValue();
		b[1] = (Integer.valueOf(lowPos)).byteValue();

		try {
			str = new String(b, "GBK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("错误");
		}

		return str;

	}

	/**
	 * 随机获取n个中文字符串
	 */
	public static String getRandonCnStr(int n) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getOnCn());
		}
		return sb.toString();

	}

	/*
	 * 方法功能：根据正则在字符串提取一段值，用于后面在url地址里提取ID值。
	 * 例如在“http://news.cnstock.com/news,yw-201908-4413224.htm”把“4413224”提取出来。
	 */
	public static String getPlaceholderValue(String src, String regex) {
		// TODO 实现代码
		Pattern pattern = Pattern.compile(regex);// 匹配的模式
		Matcher m = pattern.matcher(src);
		boolean find = m.find();
		if (find) {
			String group = m.group(0);
			return group.substring(1, group.lastIndexOf('.'));
		}
		return "";
	}

	/**
	 * 测试工具包中isNumber()
	 * 
	 * @param src
	 * @return
	 */
	public static boolean isNumber(String src) {
		// String regix="[0-9]{1,}(\\.?|[0-9]*)";
		String regix = "[0-9]{1,}\\.?[0-9]*";
		return src.matches(regix);

	}

	/**
	 * 测试工具包中hasText()，该方法是过滤String参数空格后判断是否有值，
	 * 如果你有该功能方法，但不是这个方法名不扣分。如果没有该方法，必须现在编写该方法
	 * 
	 * @param src
	 * @return
	 */
	public static boolean hasText(String src) {
		String string = src.replaceAll("\\s", "");
		return (!"".equals(string));
	}

	/*
	 * 方法功能：将字符串转换成html文本，如果遇到“\n”换行换符，则要将这一段文本使用<p></p>标签
	 * 包起来。如果遇到“\n\r”两个在一起按上面\n处理。如果只遇到一个“\r”则替换成<br/>标签。
	 * 使用场景：网页文本框传到后台的字符串就可能就会回车换行。
	 */
	public static StringBuilder toHtml(String text) {
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile("\\\n\r");
		Matcher matcher = pattern.matcher(text);
		String replaceAll = matcher.replaceAll("\n");
		String[] split = replaceAll.split("\n");
		for (String string : split) {
			String str = "<p>" + string + "</p>";
			String string2 = str.replaceAll("\r", "<br/>");
			sb.append(string2);
		}
		return sb;

	}
	/**
	 * 
	 * @Title: subRandom 
	 * @Description: 方法2：在最小值min与最大值max之间截取subs个不重复的随机数。
	 * 例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，
	 * [3,5,5]则不对，因为5重复了。应用场景：
	 * 在100篇文章中随机取10篇文章，月考可能会使用到。 (8分)
	 * @param min
	 * @param max
	 * @param subs
	 * @return
	 * @return: int[]
	 */
	public static int[] subRandom (int min, int max, int subs){
		//定义数组
		int[] values= new int[subs];
		//用来存放不重复的数据
		Set<Integer> set = new HashSet<>();
		//如果set集合中数据和subs一致则跳出循环
		while (set.size()!=subs) {
			set.add(random(min, max));
		}
		
		//遍历set放入数组
		int j=0;
		for (Integer integer : set) {
			values[j]=integer;
			j++;
		}
		return values;
	
	}
	
	/**
	 * 
	 * @Title: random 
	 * @Description: 方法1：返回min-max之间的随机整数（包含min和max值），
	 * 例如返回1-3之间的随机数，那么返回1或2或3都是正确的，
	 * 返回4就不对。 (5分)
	 * @param min
	 * @param max
	 * @return
	 * @return: int
	 */                     
	public static int random(int min, int max){
		//实例化一个Random 类
		Random r = new Random();
		//nextInt 返回的是一个小于max的随机整数,如max=10.则范湖 0-9之间的数值
		return r.nextInt(max - min  + 1 )  +min;
		
	
	}
}
