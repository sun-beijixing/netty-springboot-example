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
	 * 设备队列
	 * 
	 * @return
	 */
	@Bean
	public Queue deviceQueue() {
		return new Queue("device_queue");
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
	 * 查询队列
	 * 
	 * @return
	 */
	@Bean
	public Queue messageQueryQueue() {
		return new Queue("message_query_queue");
	}

}
