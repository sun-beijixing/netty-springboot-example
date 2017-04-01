/**
 * 
 */
package com.anyikang.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import sun.misc.BASE64Decoder;

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
	
	
	/**  
	    * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。 和bytesToInt（）配套使用 
	    * @param value  
	    *            要转换的int值 
	    * @return byte数组 
	    */    
	public static byte[] intToBytes( int value )   
	{   
	    byte[] src = new byte[4];  
	    src[3] =  (byte) ((value>>24) & 0xFF);  
	    src[2] =  (byte) ((value>>16) & 0xFF);  
	    src[1] =  (byte) ((value>>8) & 0xFF);    
	    src[0] =  (byte) (value & 0xFF);                  
	    return src;   
	}  
	 /**  
	    * 将int数值转换为占四个字节的byte数组，本方法适用于(高位在前，低位在后)的顺序。  和bytesToInt2（）配套使用 
	    */    
	public static byte[] intToBytes2(int value)   
	{   
	    byte[] src = new byte[4];  
	    src[0] = (byte) ((value>>24) & 0xFF);  
	    src[1] = (byte) ((value>>16)& 0xFF);  
	    src[2] = (byte) ((value>>8)&0xFF);    
	    src[3] = (byte) (value & 0xFF);       
	    return src;  
	}  
	
	/**  
	    * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes（）配套使用 
	    *   
	    * @param src  
	    *            byte数组  
	    * @param offset  
	    *            从数组的第offset位开始  
	    * @return int数值  
	    */    
	public static int bytesToInt(byte[] src, int offset) {  
	    int value;    
	    value = (int) ((src[offset] & 0xFF)   
	            | ((src[offset+1] & 0xFF)<<8)   
	            | ((src[offset+2] & 0xFF)<<16)   
	            | ((src[offset+3] & 0xFF)<<24));  
	    return value;  
	}  
	  
	 /**  
	    * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。和intToBytes2（）配套使用 
	    */  
	public static int bytesToInt2(byte[] src, int offset) {  
	    int value;    
	    value = (int) ( ((src[offset] & 0xFF)<<24)  
	            |((src[offset+1] & 0xFF)<<16)  
	            |((src[offset+2] & 0xFF)<<8)  
	            |(src[offset+3] & 0xFF));  
	    return value;  
	}  
	
	
	@SuppressWarnings("restriction")
	public static String decodeFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}

	public static String encodeToBASE64(String s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
	}

	public static byte[] int2bytes(int num) {
		byte[] result = new byte[4];
		result[0] = (byte) ((num >>> 24) & 0xff);
		result[1] = (byte) ((num >>> 16) & 0xff);
		result[2] = (byte) ((num >>> 8) & 0xff);
		result[3] = (byte) ((num >>> 0) & 0xff);
		return result;
	}

	public static int bytes2int(byte[] bytes) {
		int result = 0;
		if (bytes.length == 4) {
			int a = (bytes[0] & 0xff) << 24;
			int b = (bytes[1] & 0xff) << 16;
			int c = (bytes[2] & 0xff) << 8;
			int d = (bytes[3] & 0xff);
			result = a | b | c | d;
		}
		return result;
	}

	public static int byte2ToUnsignedShort(byte[] bytes, int off) {
		int high = bytes[off];
		int low = bytes[off + 1];
		return (high << 8 & 0xFF00) | (low & 0xFF);
	}

	public static byte[] shortToByteArray(short s) {
		byte[] targets = new byte[2];
		for (int i = 0; i < 2; i++) {
			int offset = (targets.length - 1 - i) * 8;
			targets[i] = (byte) ((s >>> offset) & 0xff);
		}
		return targets;
	}
	 public static byte[] shortToByte(short number) {  
	        int temp = number;  
	        byte[] b = new byte[2];  
	        for (int i = 0; i < b.length; i++) {  
	            b[i] = new Integer(temp & 0xff).byteValue();
	            temp = temp >> 8; 
	        }  
	        return b;  
	    }  

	public static void main(String[] args) {
		System.out.println(encoder("somestring"));
		System.out.println(decode("c29tZXN0cmluZw=="));
	}
}
