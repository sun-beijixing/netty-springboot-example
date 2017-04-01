package com.anyikang.remote.server;

import com.anyikang.components.zookeeper.ServiceProvider;
import com.anyikang.remote.server.service.HelloService;
import com.anyikang.remote.server.service.SendConfigurationService;
import com.anyikang.remote.server.service.impl.HelloServiceImpl;
import com.anyikang.remote.server.service.impl.SendConfigurationServiceImpl;

public class RemoteServer {
	public static void main(String[] args) throws Exception {
		
		HelloService helloService = new HelloServiceImpl();
		SendConfigurationService sendConfigurationService = new SendConfigurationServiceImpl();
		
		String host = "localhost";
		int port = 1098;
		ServiceProvider provider = new ServiceProvider();
//		provider.publish(helloService, host, port);
		provider.publish(sendConfigurationService, host, port);
		System.out.println("发布服务到zookeeper中");

//		Thread.sleep(Long.MAX_VALUE);
	}
}
