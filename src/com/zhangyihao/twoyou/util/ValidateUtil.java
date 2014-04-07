package com.zhangyihao.twoyou.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
	/**
	 * 判断给定字符串是否是一个有效邮箱 邮箱，（数字、字母、下划线） 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (email==null || email.length() == 0) {
			return false;
		} else {
			//正则表达式声明 及判断是否为有效的邮箱方法
			Pattern p = Pattern
					.compile("^[a-zA-Z0-9]+([\\w]+)*@[a-zA-Z0-9]+[-]?[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+){1,2}$");
			Matcher m = p.matcher(email);
			return (m.matches());
		}
	}
	
	public static boolean isPassword(String password) {
		if(password == null || "".equals(password.trim())) {
			return false;
		} 
		if(password.length()<6 || password.length()>20) {
			return false;
		}
		return true;
	}
	
}
