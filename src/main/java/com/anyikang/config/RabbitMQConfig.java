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
	 * 上报队列
	 * 
	 * @return
	 */
	@Bean
	public Queue reportQueue() {
		return new Queue("report_queue");
	}
	
	/**
	 * 查询响应队列
	 * 
	 * @return
	 */
	@Bean
	public Queue returnCofigQueue() {
		return new Queue("return_config_queue");
	}
	
	/**
	 * 查询响应队列
	 * 
	 * @return
	 */
	@Bean
	public Queue returnMessageQueryQueue() {
		return new Queue("return_message_query_queue");
	}

}
