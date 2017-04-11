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
import com.anyikang.util.BCDUtils;

/**
 * @author wangwei
 * @date 2017年3月30日
 */
@Service
public class ReportServiceImpl extends BaseService implements ReportService {
	
	private final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

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
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x81,dataNumberByte, 0, 4);
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
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x82,dataNumberByte, 0, 4);
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
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x83,dataNumberByte, 0, 4);
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
		String gongnengma=Integer.toHexString(dataBody[0] & 0xFF);
		
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[3] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[4] & 0xFF);
		
		byte [] timeByte={dataBody[5],dataBody[6],dataBody[7],dataBody[8],dataBody[9],dataBody[10],dataBody[11]};
		String time=BCDUtils.byteToHexString(timeByte);
		
		return super.returnObject(16,0x84,dataNumberByte, 0, 4);
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
//		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x85,dataNumberByte, 0, 4);
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
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		return super.returnObject(16,0x86,dataNumberByte, 0, 4);
	}
	
	

}
