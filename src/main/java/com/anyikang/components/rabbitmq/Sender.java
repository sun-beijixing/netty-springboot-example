package com.anyikang.components.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Scheduled(fixedDelay = 5000L)
	public void send() {
		System.out.println("---------------------server send");
		this.rabbitTemplate.convertAndSend("foo", "hello");
		this.rabbitTemplate.convertAndSend("device_queue", "zzzz");
	}

}
