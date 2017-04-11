/**
 * 
 */
package com.anyikang.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.anyikang.base.BaseService;
import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.service.HeartbeatService;

/**
 * @author wangwei
 * @date 2017年4月11日
 */
@Service
public class HeartbeatServiceImpl extends BaseService implements HeartbeatService {

	private final Logger logger = LoggerFactory.getLogger(HeartbeatServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.anyikang.service.HeartbeatService#heartbeatReport(com.anyikang.components.netty.coding.ByteToJsonBody)
	 */
	@Override
	public void heartbeatReport(ByteToJsonBody messageBody) {
		logger.debug("============心跳上报服务");

		String imeiCode = messageBody.getImeiCode();
		byte[] dataBody = messageBody.getDataBody();

		// 调用rabbitmq服务

		return;

	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.HeartbeatService#heartbeatConfig(com.anyikang.components.netty.coding.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte heartbeatConfig(ByteToJsonBody messageBody) {
		logger.debug("============心跳配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x98,dataNumberByte, 0, 4);
	}

}
