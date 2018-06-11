package it.ecommerce.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
	
	public static String getMd5Hash(String baseString) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		md.update(baseString.getBytes());
		
		byte byteData[] = md.digest();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		return sb.toString();
	}
}
