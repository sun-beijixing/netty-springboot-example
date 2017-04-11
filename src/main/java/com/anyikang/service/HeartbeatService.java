/**
 * 
 */
package com.anyikang.service;

import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;

/**
 * @author wangwei
 * @date 2017年4月11日
 */
public interface HeartbeatService {
	
	/**
	 * 心跳上报
	 * 
	 * @param messageBody
	 */
	public void heartbeatReport(ByteToJsonBody messageBody);
	
	/**
	 * 心跳配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public JsonBodyToByte heartbeatConfig(ByteToJsonBody messageBody);

}
