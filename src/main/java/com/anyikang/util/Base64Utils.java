/**
 * 
 */
package com.anyikang.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author wangwei
 * @date 2017年3月27日
 */
public class Base64Utils {
	
	/**
	 * 编码 默认utf-8
	 * @param code
	 * @return
	 */
	public static String encoder(String code) {
		String encodeStr="";
		try {
			encodeStr = Base64.getEncoder().encodeToString(code.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			System.err.println("======================编码失败======================");
			e.printStackTrace();
		}
		return encodeStr;
	}
	
	/**
	 * 编码
	 * @param code
	 * @param charsetName 字符类型
	 * @return
	 */
	public static String encoder(String code,String charsetName) {
		String encodeStr="";
		try {
			encodeStr = Base64.getEncoder().encodeToString(code.getBytes(charsetName));
		} catch (UnsupportedEncodingException e) {
			System.err.println("======================编码失败======================");
			e.printStackTrace();
		}
		return encodeStr;
	}
	
	/**
	 * 解码 默认utf-8
	 * @param code
	 * @return
	 */
	public static String decode(String code) {
		String decodeStr = "";
		byte[] asBytes = Base64.getDecoder().decode(code);
		try {
			decodeStr = new String(asBytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("======================解码失败======================");
			e.printStackTrace();
		}
		return decodeStr;
	}
	
	/**
	 * 解码
	 * @param code
	 * @param charsetName 字符类型
	 * @return
	 */
	public static String decode(String code,String charsetName) {
		String decodeStr = "";
		byte[] asBytes = Base64.getDecoder().decode(code);
		try {
			decodeStr = new String(asBytes, charsetName);
		} catch (UnsupportedEncodingException e) {
			System.err.println("======================解码失败======================");
			e.printStackTrace();
		}
		return decodeStr;
	}

	public static void main(String[] args) {
		System.out.println(encoder("somestring"));
		System.out.println(decode("c29tZXN0cmluZw=="));
	}
}
