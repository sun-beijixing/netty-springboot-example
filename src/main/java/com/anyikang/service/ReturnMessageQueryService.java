/**
 * 
 */
package com.anyikang.service;

import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;

/**
 * 查询
 * 
 * @author wangwei
 * @date 2017年3月30日
 */
public interface MessageQueryService {

	/**
	 * 版本查询
	 * 
	 * @param messageBody
	 */
	public JsonBodyToByte versions(ByteToJsonBody messageBody);

	/**
	 * 定位信息查询
	 * 
	 * @param messageBody
	 */
	public JsonBodyToByte positioning(ByteToJsonBody messageBody);

	/**
	 * 运动信息查询
	 * 
	 * @param messageBody
	 */
	public JsonBodyToByte exercise(ByteToJsonBody messageBody);

	/**
	 * 心率信息查询
	 * 
	 * @param messageBody
	 */
	public JsonBodyToByte heartRate(ByteToJsonBody messageBody);

	/**
	 * 血氧信息查询
	 * 
	 * @param messageBody
	 */
	public JsonBodyToByte bloodOxygen(ByteToJsonBody messageBody);

	/**
	 * 血压信息查询
	 * 
	 * @param messageBody
	 */
	public JsonBodyToByte bloodPressure(ByteToJsonBody messageBody);

	/**
	 * 睡眠信息查询
	 * 
	 * @param messageBody
	 */
	public JsonBodyToByte sleep(ByteToJsonBody messageBody);

	/**
	 * 丢失报文查询
	 * 
	 * @param messageBody
	 */
	public JsonBodyToByte lost(ByteToJsonBody messageBody);

}
