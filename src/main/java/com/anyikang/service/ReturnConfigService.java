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
public interface ReturnConfigService {

	/**
	 * 时间配置
	 * 
	 * @param messageBody
	 */
	public void time(ByteToJsonBody messageBody);

	/**
	 * 定位配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void positioning(ByteToJsonBody messageBody);

	/**
	 * 电子围栏配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void electronicFence(ByteToJsonBody messageBody);

	/**
	 * 亲情号配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void family(ByteToJsonBody messageBody);

	/**
	 * 运动配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void exercise(ByteToJsonBody messageBody);

	/**
	 * 白名单配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void nameList(ByteToJsonBody messageBody);

	/**
	 * 心率配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void heartRate(ByteToJsonBody messageBody);

	/**
	 * IP配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void ip(ByteToJsonBody messageBody);

	/**
	 * 闹钟配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void clock(ByteToJsonBody messageBody);

	/**
	 * wifi配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void wifi(ByteToJsonBody messageBody);

	/**
	 * 提醒配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void warn(ByteToJsonBody messageBody);

	/**
	 * 信息推送配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void informationPush(ByteToJsonBody messageBody);

	/**
	 * 恢复出厂配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void factoryReset(ByteToJsonBody messageBody);

	/**
	 * sos配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void sos(ByteToJsonBody messageBody);

	/**
	 * 跌倒配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public void tumble(ByteToJsonBody messageBody);

}
