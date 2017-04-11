/**
 * 
 */
package com.anyikang.components.rabbitmq.listener;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.anyikang.model.Device;
import com.anyikang.service.DeviceService;

/**
 * @author wangwei
 * @date 2017年4月6日
 */
@Component
//@RabbitListener(queues="device_queue")
public class DeviceListener {
	
	@Autowired
	private DeviceService deviceService;

	@RabbitHandler
	public void process(@Payload String xxx) {
		System.out.println("=====EquipmentListener=========" + new Date() + ": " + xxx);
		Device device=new Device();
		device.setId(123);
		deviceService.addDevice(device);
		//调用service层业务逻辑，存储数据
	}
}
