package com.anyikang.remote.server;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.components.zookeeper.ServiceProvider;
import com.anyikang.remote.server.service.RMIService;
import com.anyikang.remote.server.service.impl.RMIServiceImpl;

@Component
public class RemoteServer {
	
	private final Logger logger = LoggerFactory.getLogger(RemoteServer.class);
	
	@Autowired
	private RMIService rmiService;
	
	
	/**
     * 启动服务
     * @throws Exception
     */
    @PostConstruct
    public void startRMI() throws Exception {
        logger.info("================开始启动服务=================");
    	
        String host = "192.168.1.104";
		int port = 1098;
		ServiceProvider provider = new ServiceProvider();
		provider.publish(rmiService, host, port);
		System.out.println("发布服务到zookeeper中");
    }
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		RMIService rmiService = new RMIServiceImpl();
		
//		String host = "localhost";
		String host = "192.168.1.104";
		int port = 1098;
		ServiceProvider provider = new ServiceProvider();
		provider.publish(rmiService, host, port);
		System.out.println("发布服务到zookeeper中");

//		Thread.sleep(Long.MAX_VALUE);
	}
}
