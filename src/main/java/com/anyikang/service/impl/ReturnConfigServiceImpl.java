/**
 * 
 */
package com.anyikang.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.base.BaseService;
import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.service.ReturnConfigService;

/**
 * 配置响应
 * 
 * @author wangwei
 * @date 2017年3月30日
 */
@Service
public class ReturnConfigServiceImpl implements ReturnConfigService {
	
	private final Logger logger = LoggerFactory.getLogger(ReturnConfigServiceImpl.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#time(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void time(ByteToJsonBody messageBody) {
		logger.debug("============时间配置服务");
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#positioning(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public void positioning(ByteToJsonBody messageBody) {
		logger.debug("============定位配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#electronicFence(com.anyikang
	 * .util.ByteToJsonBody)
	 */
	@Override
	public void electronicFence(ByteToJsonBody messageBody) {
		logger.debug("============电子围栏配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#family(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void family(ByteToJsonBody messageBody) {
		logger.debug("============亲情号配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#nameList(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void exercise(ByteToJsonBody messageBody) {
		logger.debug("============运动配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#nameList(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void nameList(ByteToJsonBody messageBody) {
		logger.debug("============白名单配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#heartRate(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public void heartRate(ByteToJsonBody messageBody) {
		logger.debug("============心率配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#ip(com.anyikang.util.ByteToJsonBody
	 * )
	 */
	@Override
	public void ip(ByteToJsonBody messageBody) {
		logger.debug("============IP配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#clock(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void clock(ByteToJsonBody messageBody) {
		logger.debug("============闹钟配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#wifi(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void wifi(ByteToJsonBody messageBody) {
		logger.debug("============wifi配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#warn(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void warn(ByteToJsonBody messageBody) {
		logger.debug("============提醒配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#informationPush(com.anyikang
	 * .util.ByteToJsonBody)
	 */
	@Override
	public void informationPush(ByteToJsonBody messageBody) {
		logger.debug("============信息推送配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.anyikang.service.ConfigurationService#factoryReset(com.anyikang.util
	 * .ByteToJsonBody)
	 */
	@Override
	public void factoryReset(ByteToJsonBody messageBody) {
		logger.debug("============回复出厂配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#sos(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void sos(ByteToJsonBody messageBody) {
		logger.debug("============sos配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ConfigurationService#tumble(com.anyikang.util.
	 * ByteToJsonBody)
	 */
	@Override
	public void tumble(ByteToJsonBody messageBody) {
		logger.debug("============跌倒配置服务");
		// TODO Auto-generated method stub
		
		//调用rmi服务
		
		String imeiCode=messageBody.getImeiCode();
		byte[] dataBody=messageBody.getDataBody();
		
		String dataLength=Integer.toHexString(26);
		byte [] dataNumberByte={dataBody[1],dataBody[2]};
		String huifukongzhi=Integer.toHexString(dataBody[1] & 0xFF);
		String xueyang=Integer.toHexString(dataBody[2] & 0xFF);
		
		rabbitTemplate.convertAndSend("return_config_queue", "return_config msg");
	}

}
