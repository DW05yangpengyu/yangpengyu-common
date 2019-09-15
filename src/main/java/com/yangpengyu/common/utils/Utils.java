package com.yangpengyu.common.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	/**
	 * �ж��Ƿ�Ϊ��
	 */
	public static boolean isEmpty(String str) {
		// return (null==str||"".equals(str.trim()));
		return (null != str && str.trim().length() > 0);
	}

	/**
	 * ��֤�ֻ�����
	 */
	public static boolean istelephone(String str) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		boolean b = matcher.matches();
		return b;
	}

	/**
	 * ��֤����
	 */
	public static boolean isEmail(String str) {
		String regex = "^[a-z0-9A-z]{2,}@[a-z0-9A-z]{1,}\\.[a-zA-z]{2,}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		boolean b = matcher.matches();
		return b;
	}

	/**
	 * ��ȡnλ���Ӣ���ַ���
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
	 * ��ȡnλӢ�ĺ������ַ���
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
	 * �����ȡ1�������ַ���
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
			System.out.println("����");
		}

		return str;

	}

	/**
	 * �����ȡn�������ַ���
	 */
	public static String getRandonCnStr(int n) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getOnCn());
		}
		return sb.toString();

	}

	/*
	 * �������ܣ������������ַ�����ȡһ��ֵ�����ں�����url��ַ����ȡIDֵ��
	 * �����ڡ�http://news.cnstock.com/news,yw-201908-4413224.htm���ѡ�4413224����ȡ������
	 */
	public static String getPlaceholderValue(String src, String regex) {
		// TODO ʵ�ִ���
		Pattern pattern = Pattern.compile(regex);// ƥ���ģʽ
		Matcher m = pattern.matcher(src);
		boolean find = m.find();
		if (find) {
			String group = m.group(0);
			return group.substring(1, group.lastIndexOf('.'));
		}
		return "";
	}

	/**
	 * ���Թ��߰���isNumber()
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
	 * ���Թ��߰���hasText()���÷����ǹ���String�����ո���ж��Ƿ���ֵ��
	 * ������иù��ܷ�����������������������۷֡����û�и÷������������ڱ�д�÷���
	 * 
	 * @param src
	 * @return
	 */
	public static boolean hasText(String src) {
		String string = src.replaceAll("\\s", "");
		return (!"".equals(string));
	}

	/*
	 * �������ܣ����ַ���ת����html�ı������������\n�����л�������Ҫ����һ���ı�ʹ��<p></p>��ǩ
	 * �����������������\n\r��������һ������\n�������ֻ����һ����\r�����滻��<br/>��ǩ��
	 * ʹ�ó�������ҳ�ı��򴫵���̨���ַ����Ϳ��ܾͻ�س����С�
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
	 * @Description: ����2������Сֵmin�����ֵmax֮���ȡsubs�����ظ����������
	 * ������1-10֮��ȡ3�����ظ������������ô[2,6,9]�ǶԵģ�
	 * [3,5,5]�򲻶ԣ���Ϊ5�ظ��ˡ�Ӧ�ó�����
	 * ��100ƪ���������ȡ10ƪ���£��¿����ܻ�ʹ�õ��� (8��)
	 * @param min
	 * @param max
	 * @param subs
	 * @return
	 * @return: int[]
	 */
	public static int[] subRandom (int min, int max, int subs){
		//��������
		int[] values= new int[subs];
		//������Ų��ظ�������
		Set<Integer> set = new HashSet<>();
		//���set���������ݺ�subsһ��������ѭ��
		while (set.size()!=subs) {
			set.add(random(min, max));
		}
		
		//����set��������
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
	 * @Description: ����1������min-max֮����������������min��maxֵ����
	 * ���緵��1-3֮������������ô����1��2��3������ȷ�ģ�
	 * ����4�Ͳ��ԡ� (5��)
	 * @param min
	 * @param max
	 * @return
	 * @return: int
	 */                     
	public static int random(int min, int max){
		//ʵ����һ��Random ��
		Random r = new Random();
		//nextInt ���ص���һ��С��max���������,��max=10.�򷶺� 0-9֮�����ֵ
		return r.nextInt(max - min  + 1 )  +min;
		
	
	}
}
