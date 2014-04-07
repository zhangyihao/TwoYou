package com.zhangyihao.twoyou.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String enctry(String str) {
		MessageDigest messageDigest;
		StringBuilder sb = new StringBuilder();
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes());
			byte[] result=  messageDigest.digest();
			
			
			for(int i=0; i<result.length; i++) {
				int hi = ((result[i]>>4)&0x0F);
				int lo = (result[i]&0x0F);
				sb.append(hi>9?(char)(hi - 10 + 'a'):(char)(hi + '0'));
				sb.append(lo>9?(char)(lo - 10 + 'a'):(char)(lo + '0'));
			}
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
