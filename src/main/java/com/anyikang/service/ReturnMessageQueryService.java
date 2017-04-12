/**
 * 
 */
package com.anyikang.service;

import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;

/**
 * 查询响应
 * 
 * @author wangwei
 * @date 2017年3月30日
 */
public interface ReturnMessageQueryService {

	/**
	 * 版本查询响应
	 * 
	 * @param messageBody
	 */
	public void versions(ByteToJsonBody messageBody);

	/**
	 * 定位信息查询响应
	 * 
	 * @param messageBody
	 */
	public void positioning(ByteToJsonBody messageBody);

	/**
	 * 运动信息查询
	 * 
	 * @param messageBody
	 */
	public void exercise(ByteToJsonBody messageBody);

	/**
	 * 心率信息查询
	 * 
	 * @param messageBody
	 */
	public void heartRate(ByteToJsonBody messageBody);

	/**
	 * 血氧信息查询
	 * 
	 * @param messageBody
	 */
	public void bloodOxygen(ByteToJsonBody messageBody);

	/**
	 * 血压信息查询
	 * 
	 * @param messageBody
	 */
	public void bloodPressure(ByteToJsonBody messageBody);

	/**
	 * 睡眠信息查询
	 * 
	 * @param messageBody
	 */
	public void sleep(ByteToJsonBody messageBody);

	/**
	 * 丢失报文查询
	 * 
	 * @param messageBody
	 */
	public void lost(ByteToJsonBody messageBody);

}
