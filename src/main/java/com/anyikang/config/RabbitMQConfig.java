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
	
	@Bean
	public Queue fooQueue() {
		return new Queue("foo");//默认为持久化，可以根据不同使用场景选择对应的构造函数
	}

}
