package com.anyikang.remote.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.components.netty.server.NettyServer;
import com.anyikang.components.zookeeper.ServiceProvider;
import com.anyikang.remote.server.service.HelloService;
import com.anyikang.remote.server.service.SendConfigurationService;
import com.anyikang.remote.server.service.impl.HelloServiceImpl;
import com.anyikang.remote.server.service.impl.SendConfigurationServiceImpl;

@Component
public class RemoteServer {
	
	private final Logger logger = LoggerFactory.getLogger(RemoteServer.class);
	
	@Autowired
	private HelloService helloService;
	@Autowired
	private SendConfigurationService sendConfigurationService;
	
	
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
//		provider.publish(helloService, host, port);
		provider.publish(sendConfigurationService, host, port);
		System.out.println("发布服务到zookeeper中");
    }
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		HelloService helloService = new HelloServiceImpl();
		SendConfigurationService sendConfigurationService = new SendConfigurationServiceImpl();
		
//		String host = "localhost";
		String host = "192.168.1.104";
		int port = 1098;
		ServiceProvider provider = new ServiceProvider();
		provider.publish(helloService, host, port);
		provider.publish(sendConfigurationService, host, port);
		System.out.println("发布服务到zookeeper中");

//		Thread.sleep(Long.MAX_VALUE);
	}
}
