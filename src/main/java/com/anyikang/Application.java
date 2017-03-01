
package com.anyikang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author wangwei
 * @date 2017年3月1日
 */
@SpringBootApplication
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