/**
 * 
 */
package com.anyikang.tasks;

import java.util.List;

import io.netty.channel.Channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.components.netty.session.ChannelsSession;
import com.anyikang.components.netty.session.ChannelsSessionManager;
import com.anyikang.model.Device;
import com.anyikang.service.DeviceService;

/**
 * @author wangwei
 * @date 2017年4月6日
 */
@Component
public class TaskHandler {

	public static final Logger logger = LoggerFactory.getLogger(TaskHandler.class);
	
	@Autowired
	private ChannelsSessionManager channelsSessionManager;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private DeviceService deviceService;

	//需要懂队列里边逐一取出进行配置
	
	
	/**
	 * 时间
	 */
	@Scheduled(cron = "0 0 1 * * ?")
	private void timeConfig() {
		logger.info("==========开启时间配置任务===========");
		
		List<Device> devices=deviceService.getDevices();
		for(Device device:devices){
			
			String sessionId="001"+device.getId();
			ChannelsSession channelsSession=channelsSessionManager.findById(sessionId);
			System.err.println("channelsSession:"+channelsSession);
			Channel channel=channelsSession.getChannel();
			JsonBodyToByte jb =new JsonBodyToByte();
			jb.setBeginCode(0x68);
			jb.setImeiCode("1111");
			jb.setDataLength((byte)16);
			jb.setFunctionCode((byte) 1);
			jb.setMark(0x01);
			jb.setErrCode((byte) 0);
			jb.setErrMsg((byte)0x01);
			jb.setCrc((byte) 0x56);
			jb.setEndCode(0x16);
			
			channel.writeAndFlush(jb);
		}
		


	}
	
	/**
	 * IP
	 */
	@Scheduled(cron = "0 0 2 * * ?")
	private void ipConfig() {
		logger.info("==========开启IP配置任务===========");
		long begin = System.currentTimeMillis();
		
	}
	
	/**
	 * 端口
	 */
	@Scheduled(cron = "0 0 3 * * ?")
	private void portConfig() {
		logger.info("==========开启端口配置任务===========");
		
	}
}
