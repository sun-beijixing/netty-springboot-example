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
import com.anyikang.service.ConfigurationService;

/**
 * 配置
 * 
 * @author wangwei
 * @date 2017年3月30日
 */
@Service
public class ConfigurationServiceImpl extends BaseService implements ConfigurationService {
	
	private final Logger logger = LoggerFactory.getLogger(ConfigurationServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#time(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte time(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x90,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#positioning(com.anyikang.util
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
		
		return super.returnObject(16,0x91,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#electronicFence(com.anyikang
	 * .util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte electronicFence(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x92,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#family(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte family(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x93,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#nameList(com.anyikang.util.
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
		
		return super.returnObject(16,0x94,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#nameList(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte nameList(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x95,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#heartRate(com.anyikang.util
	 * .ByteToJsonBody)
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
		
		return super.returnObject(16,0x96,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#ip(com.anyikang.util.ByteToJsonBody
	 * )
	 */
	@Override
	public JsonBodyToByte ip(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x97,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#heartbeat(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte heartbeat(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x98,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#clock(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte clock(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x99,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#wifi(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte wifi(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x9A,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#warn(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte warn(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x9B,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#informationPush(com.anyikang
	 * .util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte informationPush(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x9C,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#factoryReset(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte factoryReset(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x9D,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#sos(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte sos(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x9E,liushuihao, 0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#tumble(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte tumble(ByteToJsonBody messageBody) {
		logger.debug("============定位上报服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x9F,liushuihao, 0, 4);
	}

}
