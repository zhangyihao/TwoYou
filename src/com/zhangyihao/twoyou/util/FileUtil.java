package com.zhangyihao.twoyou.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class FileUtil {
	
	public static String getRoot() {
		String path = FileUtil.class.getResource("/").getPath();
		return path.substring(0, path.indexOf("WEB-INF"));
	}
	
	public static void copyFile(File source, File dest) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = in.read(buf))!=-1) {
				out.write(buf, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out!=null) {
					out.close();
				}
				if(in!=null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getHeadImagePath(String path, String size) {
		StringBuffer sb = new StringBuffer();
		sb.append(path.substring(0, path.lastIndexOf(".")));
		sb.append(size.toUpperCase());
		sb.append(path.substring(path.lastIndexOf(".")));
		return sb.toString();
	}
	
}
