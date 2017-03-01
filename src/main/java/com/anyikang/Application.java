
package com.anyikang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anyikang.netty.TCPServer;

/**
 * 
 * @author wangwei
 * @date 2017年3月1日
 */
@SpringBootApplication
public class Application {
	
	public static final Logger logger = LoggerFactory.getLogger(Application.class);  

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        
        logger.info("|======================================================|");
		logger.info("|======================================================|");
		logger.info("|---------------(SpringBoot Start Success)-------------|");
		logger.info("|======================================================|");
		logger.info("|======================================================|");
		
        TCPServer tcpServer = context.getBean(TCPServer.class);
        tcpServer.start();

    }


}