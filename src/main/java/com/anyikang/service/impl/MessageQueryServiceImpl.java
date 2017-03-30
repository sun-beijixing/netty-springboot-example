/**
 * 
 */
package com.anyikang.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.anyikang.service.MessageQueryService;
import com.anyikang.util.ByteToJsonBody;

/**
 * 查询
 * 
 * @author wangwei
 * @date 2017年3月30日
 */
@Service
public class MessageQueryServiceImpl implements MessageQueryService {
	
	private final Logger logger = LoggerFactory.getLogger(MessageQueryServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#versions(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public String versions(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#positioning(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public String positioning(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#exercise(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public String exercise(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#heartRate(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public String heartRate(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#bloodOxygen(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public String bloodOxygen(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.MessageQueryService#bloodPressure(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public String bloodPressure(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#sleep(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public String sleep(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.MessageQueryService#lost(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public String lost(ByteToJsonBody messageBody) {
		// TODO Auto-generated method stub
		return null;
	}

}
