package com.anyikang.remote.server;

import com.anyikang.components.zookeeper.ServiceProvider;
import com.anyikang.remote.server.impl.HelloServiceImpl;
import com.anyikang.remote.server.service.HelloService;

public class Server {
	public static void main(String[] args) throws Exception {
		
		HelloService helloService = new HelloServiceImpl();
		
		String host = "localhost";
		int port = 1096;
		ServiceProvider provider = new ServiceProvider();
		provider.publish(helloService, host, port);
		System.out.println("发布服务到zookeeper中");

//		Thread.sleep(Long.MAX_VALUE);
	}
}
