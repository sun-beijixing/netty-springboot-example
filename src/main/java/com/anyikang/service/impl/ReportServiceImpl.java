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
import com.anyikang.service.ReportService;

/**
 * @author wangwei
 * @date 2017年3月30日
 */
@Service
public class ReportServiceImpl extends BaseService implements ReportService {
	
	private final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#heartbeat(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public void heartbeat(ByteToJsonBody messageBody) {
		logger.debug("============心跳上报服务");
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		//调用rabbitmq服务
		
		return;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#positioning(com.anyikang.util.ByteToJsonBody)
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
		
		return super.returnObject(16,0x81,liushuihao, 0, 4);
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#exercise(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte exercise(ByteToJsonBody messageBody) {
		logger.debug("============运动上报服务");
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x82,liushuihao, 0, 4);
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#heartRate(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte heartRate(ByteToJsonBody messageBody) {
		logger.debug("============心率上报服务");
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x83,liushuihao, 0, 4);
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#bloodOxygen(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte bloodOxygen(ByteToJsonBody messageBody) {
		logger.debug("============血氧上报服务");
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x84,liushuihao, 0, 4);
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#bloodPressure(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte bloodPressure(ByteToJsonBody messageBody) {
		logger.debug("============血压上报服务");
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x85,liushuihao, 0, 4);
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#sleep(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte sleep(ByteToJsonBody messageBody) {
		logger.debug("============睡眠上报服务");
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String liushuihao=Integer.toHexString(dataBody[0] & 0xFF);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x86,liushuihao, 0, 4);
	}
	
	

}
