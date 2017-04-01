package com.anyikang.remote.client;

import com.anyikang.components.zookeeper.ServiceConsumer;
import com.anyikang.remote.server.service.HelloService;
import com.anyikang.remote.server.service.SendConfigurationService;


public class RemoteClient {
	public static void main(String[] args) throws Exception {
		ServiceConsumer consumer = new ServiceConsumer();

//		while (true) {
//			HelloService helloService = consumer.lookup();
//			String result = helloService.sayHello("Jack");
//			System.out.println(result);
//			Thread.sleep(3000);
//		}
		
		SendConfigurationService scs = consumer.lookup();
		scs.time("");
	}
}
