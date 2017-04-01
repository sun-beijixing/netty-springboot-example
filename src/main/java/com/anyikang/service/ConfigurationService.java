/**
 * 
 */
package com.anyikang.service;

import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;

/**
 * @author wangwei
 * @date 2017年3月30日
 */
public interface ConfigurationService {

	/**
	 * 时间配置
	 * 
	 * @param messageBody
	 */
	public JsonBodyToByte time(ByteToJsonBody messageBody);

	/**
	 * 定位配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte positioning(ByteToJsonBody messageBody);

	/**
	 * 电子围栏配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte electronicFence(ByteToJsonBody messageBody);

	/**
	 * 亲情号配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte family(ByteToJsonBody messageBody);

	/**
	 * 运动配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte exercise(ByteToJsonBody messageBody);

	/**
	 * 白名单配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte nameList(ByteToJsonBody messageBody);

	/**
	 * 心率配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte heartRate(ByteToJsonBody messageBody);

	/**
	 * IP配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte ip(ByteToJsonBody messageBody);

	/**
	 * 心跳配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte heartbeat(ByteToJsonBody messageBody);

	/**
	 * 闹钟配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte clock(ByteToJsonBody messageBody);

	/**
	 * wifi配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte wifi(ByteToJsonBody messageBody);

	/**
	 * 提醒配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte warn(ByteToJsonBody messageBody);

	/**
	 * 信息推送配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte informationPush(ByteToJsonBody messageBody);

	/**
	 * 恢复出厂配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte factoryReset(ByteToJsonBody messageBody);

	/**
	 * sos配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte sos(ByteToJsonBody messageBody);

	/**
	 * 跌倒配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte tumble(ByteToJsonBody messageBody);

}
