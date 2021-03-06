/**
 * 
 */
package com.anyikang.base;

import com.anyikang.components.netty.coding.JsonBodyToByte;

/**
 * @author wangwei
 * @date 2017年3月31日
 */
public class BaseService {
	
	/**
	 * 响应结果
	 * @param dataLength
	 * @param liushuihao
	 * @param errCode
	 * @param errMsg
	 * @return
	 */
	protected JsonBodyToByte returnObject(int dataLength,int functionCode,byte[] liushuihao,int errCode,int errMsg){
		JsonBodyToByte jb=new JsonBodyToByte();
		jb.setDataLength((byte)dataLength);
//		jb.setDataLength((byte)0x16);
		jb.setFunctionCode(functionCode);
		jb.setDataNumber(liushuihao);
		jb.setErrCode((byte) errCode);
		jb.setErrMsg((byte)errMsg);
		jb.setServerType(1);
		return jb;
	}
	
	/**
	 * 响应结果
	 * @param dataLength
	 * @param liushuihao
	 * @param errCode
	 * @param errMsg
	 * @return
	 */
	protected JsonBodyToByte returnObject(int dataLength,int functionCode,int errCode,int errMsg){
		JsonBodyToByte jb=new JsonBodyToByte();
		jb.setDataLength((byte)dataLength);
//		jb.setDataLength((byte)0x16);
		jb.setFunctionCode(functionCode);
		jb.setErrCode((byte) errCode);
		jb.setErrMsg((byte)errMsg);
		jb.setServerType(2);
		return jb;
	}

}
