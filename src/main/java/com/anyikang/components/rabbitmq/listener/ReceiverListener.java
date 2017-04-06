package com.anyikang.components.rabbitmq;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "foo")// 启用Rabbit队列监听foo key.
public class Receiver {

	@RabbitHandler
	public void process(@Payload String foo) {
		System.out.println("==============" + new Date() + ": " + foo);
	}
}
