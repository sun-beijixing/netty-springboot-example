/**
 * 
 */
package com.anyikang.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.anyikang.components.netty.handler.ReportServerHandler;
import com.anyikang.service.ReportService;
import com.anyikang.util.ByteToJsonBody;

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
		// TODO Auto-generated method stub
		System.out.println("============心跳上报服务");
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#positioning(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public String positioning(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#exercise(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public String exercise(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#heartRate(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public String heartRate(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#bloodOxygen(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public String bloodOxygen(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#bloodPressure(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public String bloodPressure(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.FunctionService#sleep(com.anyikang.util.ByteToJsonBody)
	 */
	@Override
	public String sleep(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

}
