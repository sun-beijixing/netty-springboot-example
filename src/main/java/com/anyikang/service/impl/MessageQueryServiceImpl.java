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
import com.anyikang.service.MessageQueryService;

/**
 * 查询
 * 
 * @author wangwei
 * @date 2017年3月30日
 */
@Service
public class MessageQueryServiceImpl extends BaseService implements MessageQueryService {
	
	private final Logger logger = LoggerFactory.getLogger(MessageQueryServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#versions(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte versions(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16, liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#positioning(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte positioning(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16, liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#exercise(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte exercise(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16, liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#heartRate(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte heartRate(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16, liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#bloodOxygen(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte bloodOxygen(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16, liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#bloodPressure(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte bloodPressure(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16, liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#sleep(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte sleep(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16, liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#lost(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte lost(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16, liushuihao, 0, 4);
	}

}
