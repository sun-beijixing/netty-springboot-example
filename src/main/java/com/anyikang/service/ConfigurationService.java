/**
 * 
 */
package com.anyikang.service;

import com.anyikang.components.netty.coding.ByteToJsonBody;

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
	public String time(ByteToJsonBody messageBody);

	/**
	 * 定位配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String positioning(ByteToJsonBody messageBody);

	/**
	 * 电子围栏配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String electronicFence(ByteToJsonBody messageBody);

	/**
	 * 亲情号配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String family(ByteToJsonBody messageBody);

	/**
	 * 运动配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String exercise(ByteToJsonBody messageBody);

	/**
	 * 白名单配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String nameList(ByteToJsonBody messageBody);

	/**
	 * 心率配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String heartRate(ByteToJsonBody messageBody);

	/**
	 * IP配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String ip(ByteToJsonBody messageBody);

	/**
	 * 心跳配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String heartbeat(ByteToJsonBody messageBody);

	/**
	 * 闹钟配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String clock(ByteToJsonBody messageBody);

	/**
	 * wifi配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String wifi(ByteToJsonBody messageBody);

	/**
	 * wifi配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String warn(ByteToJsonBody messageBody);

	/**
	 * 信息推送配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String informationPush(ByteToJsonBody messageBody);

	/**
	 * 恢复出厂配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String factoryReset(ByteToJsonBody messageBody);

	/**
	 * sos配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String sos(ByteToJsonBody messageBody);

	/**
	 * 跌倒配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public String tumble(ByteToJsonBody messageBody);

}
