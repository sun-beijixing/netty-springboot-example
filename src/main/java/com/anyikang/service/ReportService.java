/**
 * 
 */
package com.anyikang.service;

import com.anyikang.components.netty.coding.ByteToJsonBody;

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
	public String positioning(ByteToJsonBody messageBody);

	/**
	 * 运动上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public String exercise(ByteToJsonBody messageBody);

	/**
	 * 心率上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public String heartRate(ByteToJsonBody messageBody);

	/**
	 * 血氧上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public String bloodOxygen(ByteToJsonBody messageBody);

	/**
	 * 血压上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public String bloodPressure(ByteToJsonBody messageBody);

	/**
	 * 睡眠上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public String sleep(ByteToJsonBody messageBody);

}
