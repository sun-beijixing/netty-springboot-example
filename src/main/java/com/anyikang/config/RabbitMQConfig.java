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
	 * 心跳队列
	 * 
	 * @return
	 */
	@Bean
	public Queue heartbeatQueue() {
		return new Queue("heartbeat_queue");// 默认为持久化，可以根据不同使用场景选择对应的构造函数
	}

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
