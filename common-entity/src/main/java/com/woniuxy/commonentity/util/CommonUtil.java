package com.woniuxy.commonentity.util;

import org.apache.commons.beanutils.BeanUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

public class CommonUtil {

	public static <T> T mapToBean(Map map,Class<T> clazz) {
		T t;
		try {
			t = clazz.newInstance();
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 
		return t;
	}
	
	public static String  getMD5String(String str) {
		//创建支持MD5算法加密的核心类
		try {
			MessageDigest messageDigest=MessageDigest.getInstance("MD5");
			//加密出来的是一个字节数组
			byte[] bytes = messageDigest.digest(str.getBytes());
			//bytes是16位：将每一位格式化成两位的十六进制，就是标准的32位的MD5加密后的编码
			System.out.println(Arrays.toString(bytes));
			StringBuilder sb=new StringBuilder();
			for(byte b:bytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

	}
	
	//生成uuid
	 public static String getUUID() {
	        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
	    }
	
}
