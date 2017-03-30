/**
 * 
 */
package com.anyikang.service;

import com.anyikang.components.netty.coding.ByteToJsonBody;

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
	public String versions(ByteToJsonBody messageBody);

	/**
	 * 定位信息查询
	 * 
	 * @param messageBody
	 */
	public String positioning(ByteToJsonBody messageBody);

	/**
	 * 运动信息查询
	 * 
	 * @param messageBody
	 */
	public String exercise(ByteToJsonBody messageBody);

	/**
	 * 心率信息查询
	 * 
	 * @param messageBody
	 */
	public String heartRate(ByteToJsonBody messageBody);

	/**
	 * 血氧信息查询
	 * 
	 * @param messageBody
	 */
	public String bloodOxygen(ByteToJsonBody messageBody);

	/**
	 * 血压信息查询
	 * 
	 * @param messageBody
	 */
	public String bloodPressure(ByteToJsonBody messageBody);

	/**
	 * 睡眠信息查询
	 * 
	 * @param messageBody
	 */
	public String sleep(ByteToJsonBody messageBody);

	/**
	 * 丢失报文查询
	 * 
	 * @param messageBody
	 */
	public String lost(ByteToJsonBody messageBody);

}
