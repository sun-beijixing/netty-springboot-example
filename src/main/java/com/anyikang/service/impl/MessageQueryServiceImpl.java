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
		logger.debug("============版本查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0xB0,dataNumberByte, 0, 4);
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
		logger.debug("============定位信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0xB1,dataNumberByte, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#exercise(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte exercise(ByteToJsonBody messageBody) {
		logger.debug("============运动信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0xB2,dataNumberByte, 0, 4);
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
		logger.debug("============心率信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0xB3,dataNumberByte, 0, 4);
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
		logger.debug("============血氧信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0xB4,dataNumberByte, 0, 4);
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
		logger.debug("============血压信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0xB5,dataNumberByte, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#sleep(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte sleep(ByteToJsonBody messageBody) {
		logger.debug("============睡眠信息查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0xB6,dataNumberByte, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#lost(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte lost(ByteToJsonBody messageBody) {
		logger.debug("============丢失报文查询服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0xB7,dataNumberByte, 0, 4);
	}

}
