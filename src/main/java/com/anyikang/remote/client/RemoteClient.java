package com.anyikang.remote.client;

import com.anyikang.components.zookeeper.ServiceConsumer;
import com.anyikang.remote.server.service.RMIService;


public class RemoteClient {
	public static void main(String[] args) throws Exception {
		ServiceConsumer consumer = new ServiceConsumer();

		RMIService rmiService = consumer.lookup();
			String result = rmiService.sayHello("Jack");
			System.out.println(result);
//		}
		
	}
}
