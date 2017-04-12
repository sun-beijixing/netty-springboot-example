package com.anyikang.components.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

//	@Scheduled(fixedDelay = 5000L)
//	public void send() {
//		System.out.println("---------------------rabbitmq server send:");
//		this.rabbitTemplate.convertAndSend("device_queue", "device number");
//		this.rabbitTemplate.convertAndSend("report_queue", "device number");
//		this.rabbitTemplate.convertAndSend("return_config_queue", "device number");
//		this.rabbitTemplate.convertAndSend("return_message_query_queue", "device number");
//	}

}
