/**
 * 
 */
package com.anyikang.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.components.netty.handler.ReportServerHandler;
import com.anyikang.service.ReportService;
import com.anyikang.util.BCDUtils;

/**
 * @author wangwei
 * @date 2017年3月30日
 */
@Service
public class ReportServiceImpl implements ReportService{
	
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
		
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#positioning(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte positioning(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#exercise(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte exercise(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#heartRate(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte heartRate(ByteToJsonBody messageBody) {
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		return null;
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
		
		JsonBodyToByte jb=new JsonBodyToByte();
		jb.setDataLength((byte)16);
//		jb.setDataLength((byte)0x16);
		jb.setFunctionCode(0x84);
		jb.setDataNumber((byte)Integer.parseInt(liushuihao));
		jb.setErrCode((byte) 0);
		jb.setErrMsg((byte)4);
		return jb;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#bloodPressure(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte bloodPressure(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#sleep(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public JsonBodyToByte sleep(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
