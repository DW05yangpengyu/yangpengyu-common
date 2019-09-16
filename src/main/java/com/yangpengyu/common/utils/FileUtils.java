package com.yangpengyu.common.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



public class FileUtils {
	public static Logger log = Logger.getLogger(FileUtils.class); 
	/**
	 * 	获取文件扩展名
	 * @param fileName
	 * @return
	 */
	public static String getsuffix(String fileName){
		int indexOf = fileName.lastIndexOf('.');
		//没有扩展名
		if(indexOf<0){
			return "";
		}
		//最后一位是.
		if(indexOf>=fileName.length()){
			return "";
		}
		return fileName.substring(indexOf+1);
		
	}
	
	/**
	 * 3.5.3删除文件
	 * 
	 * 如果是目录，则下面的文件和所有子目录中的文件都要删除
		使用递归。涉及内容。判断目录的存在性，判断是否为目录或文件，删除。
	 * @return 
	 */
	public static void delFilePath(String fileName){
		
		File file = new File(fileName);
		if(!file.exists()){
			return;
		}
		if(file.isDirectory()){
			String[] list = file.list();
			for (String string : list) {
				delFilePath(fileName+"/"+string);
				
			}
			log.info(" ------------ 删除文件 夹 ： " + fileName);
			file.delete();
		}else{
			log.info("删除文件"+fileName);
			file.delete();
			return;
		}
		
	}
	public long getSize(String fileName,fileUnit fileunit){
		File ff = new File(fileName);
		if (ff.exists() && ff.isFile()) {
		long size = ff.length();
			switch(fileunit){
				case B:
					return size;
				case KB:
					return size/1024;
				case MB:
					return size/1024/1024;
				case GB:
					return size/1024/1024/1024;
				case TB:
					return size/1024/1024/1024/1024;
				case PB:
					return size/1024/1024/1024/1024/1024;
				default:
					return 0;
			}
		}else{
			return 0;
		}
	}
	/*
	 *关闭流 
	 */
	public static void closeSteam(Closeable ...closeables) throws IOException{
		for (Closeable closeable : closeables) {
			closeable.close();
		}
	}
	
	/**
	 * 复制流
	 * @throws IOException 
	 */
	public static void copySteam(InputStream is,OutputStream os) throws IOException{
		byte b []=new  byte[1024];
		while(is.read(b)>0){
			os.write(b);
		}
		os.flush();
	}
	
	/**
     * 按行读取文件
     */
	public static void ReadFileByLine(String filename) {
        File file = new File(filename);
        InputStream is = null;
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
            is = new FileInputStream(file);
            reader = new InputStreamReader(is);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedReader)
                    bufferedReader.close();
                if (null != reader)
                    reader.close();
                if (null != is)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	/**
	 * 按字节读取文件
	 * 
	 * @param filename
	 */
	public static void ReadFileByBytes(String filename) {
		File file = new File(filename);
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			int index = 0;
			while (-1 != (index = is.read())) {
				System.out.write(index);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != is)
					is.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("-----------------------------------");
		try {
			is = new FileInputStream(file);
			byte[] tempbyte = new byte[1000];
			int index = 0;
			while (-1 != (index = is.read(tempbyte))) {
				System.out.write(tempbyte, 0, index);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != is)
					is.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 按字符读取文件
	 * 
	 * @param filename
	 */
	public static void ReadFileByChar(String filename) {
		File file = new File(filename);
		InputStream is = null;
		Reader isr = null;
		try {
			is = new FileInputStream(file);
			isr = new InputStreamReader(is);
			int index = 0;
			while (-1 != (index = isr.read())) {
				System.out.print((char) index);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != is)
					is.close();
				if (null != isr)
					isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 通过BufferedWriter写文件
	 * 
	 * @param filename
	 */
	public static void Write2FileByBuffered(String filename) {
		File file = new File(filename);
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			bw.write("Write2FileByBuffered");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != bw) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != osw) {
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 *网络文件下载
	 */
	public static void download(String realPath,HttpServletRequest request,HttpServletResponse response,String filename) throws FileNotFoundException {
		 /* // 下载本地文件
	    String fileName = "Operator.doc".toString(); // 文件的默认保存名
*/	    // 读到流中
	    InputStream inStream = new FileInputStream(realPath+filename);// 文件的存放路径
	    // 设置输出的格式
	    response.reset();
	    response.setContentType("bin");
	    response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
	   
	    // 循环取出流中的数据
	    byte[] b = new byte[1024];
	    int len;
	    try {
	      while ((len = inStream.read(b)) > 0)
	        response.getOutputStream().write(b, 0, len);
	      inStream.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	/*
	 * 
	 */
	public static List filToBean(String fileName,Constructor constructor) throws Exception{
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String lineString=null;
		List list = new ArrayList();
		while((lineString=br.readLine())!=null){
			String[] split = lineString.split("\\||");
			Object object = constructor.newInstance(split);
			list.add(object);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
}
