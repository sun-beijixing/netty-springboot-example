/**
 * 
 */
package com.anyikang.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangwei
 * @date 2017年3月14日
 */
@Configuration
public class RabbitMQConfig {

	/**
	 * 定位队列
	 * 
	 * @return
	 */
	@Bean
	public Queue positioningQueue() {
		return new Queue("positioning_queue");
	}

	/**
	 * 设备队列
	 * 
	 * @return
	 */
	@Bean
	public Queue deviceQueue() {
		return new Queue("device_queue");
	}

}
