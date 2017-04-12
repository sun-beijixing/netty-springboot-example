/**
 * 
 */
package com.anyikang.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.service.ReturnMessageQueryService;

/**
 * 查询
 * 
 * @author wangwei
 * @date 2017年3月30日
 */
@Service
public class ReturnMessageQueryServiceImpl implements ReturnMessageQueryService {
	
	private final Logger logger = LoggerFactory.getLogger(ReturnMessageQueryServiceImpl.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#versions(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void versions(ByteToJsonBody messageBody) {
		logger.debug("============版本号查询服务响应");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		
		rabbitTemplate.convertAndSend("return_message_query_queue", "return_message_query msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#positioning(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public void positioning(ByteToJsonBody messageBody) {
		logger.debug("============定位信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_message_query_queue", "return_message_query msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#exercise(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void exercise(ByteToJsonBody messageBody) {
		logger.debug("============运动信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_message_query_queue", "return_message_query msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#heartRate(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void heartRate(ByteToJsonBody messageBody) {
		logger.debug("============心率信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_message_query_queue", "return_message_query msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#bloodOxygen(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public void bloodOxygen(ByteToJsonBody messageBody) {
		logger.debug("============血氧信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_message_query_queue", "return_message_query msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#bloodPressure(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public void bloodPressure(ByteToJsonBody messageBody) {
		logger.debug("============血压信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_message_query_queue", "return_message_query msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#sleep(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void sleep(ByteToJsonBody messageBody) {
		logger.debug("============睡眠信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_message_query_queue", "return_message_query msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#lost(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void lost(ByteToJsonBody messageBody) {
		logger.debug("============丢失报文查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_message_query_queue", "return_message_query msg");
	}

}
