
package com.anyikang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.anyikang.netty.TCPServer;

/**
 * Spring Java Configuration and Bootstrap
 *
 * @author wangwei                 
 */
@SpringBootApplication
public class Application {
	
	public static final Logger logger = LoggerFactory.getLogger(Application.class);  

    @Configuration
    @Profile("production")
    @PropertySource("classpath:/properties/production/nettyserver.properties")
    static class Production
    { }

    @Configuration
    @Profile("local")
    @PropertySource({"classpath:/properties/local/nettyserver.properties"})
    static class Local
    { }

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