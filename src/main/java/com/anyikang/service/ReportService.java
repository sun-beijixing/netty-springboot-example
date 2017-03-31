/**
 * 
 */
package com.anyikang.service;

import java.util.Map;

import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;

/**
 * 上报
 * 
 * @author wangwei
 * @date 2017年3月30日
 */
public interface ReportService {

	/**
	 * 心跳上报
	 * 
	 * @param messageBody
	 */
	public void heartbeat(ByteToJsonBody messageBody);

	/**
	 * 定位上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte positioning(ByteToJsonBody messageBody);

	/**
	 * 运动上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte exercise(ByteToJsonBody messageBody);

	/**
	 * 心率上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte heartRate(ByteToJsonBody messageBody);

	/**
	 * 血氧上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte bloodOxygen(ByteToJsonBody messageBody);

	/**
	 * 血压上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte bloodPressure(ByteToJsonBody messageBody);

	/**
	 * 睡眠上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte sleep(ByteToJsonBody messageBody);

}
