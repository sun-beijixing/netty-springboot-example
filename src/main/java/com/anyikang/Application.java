
package com.anyikang;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
//import com.anyikang.components.redis.RedisTest;

/**
 * 
 * @author wangwei
 * @date 2017年3月1日
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.anyikang.dao.mapper")
@EnableScheduling//启用任务调度.
public class Application {
	
	public static final Logger logger = LoggerFactory.getLogger(Application.class);  
	
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);
        
        logger.info("|======================================================|");
		logger.info("|======================================================|");
		logger.info("|---------------(SpringBoot Start Success)-------------|");
		logger.info("|======================================================|");
		logger.info("|======================================================|");
		
    }
    


}