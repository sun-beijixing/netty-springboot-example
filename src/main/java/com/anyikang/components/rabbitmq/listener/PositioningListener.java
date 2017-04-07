package com.anyikang.components.rabbitmq.listener;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "positioning_queue")// 启用Rabbit队列监听foo key.
public class PositioningListener {

	@RabbitHandler
	public void process(@Payload String msg) {
		System.out.println("=====PositioningListener=========" + new Date() + ": " + msg);
	}
}
