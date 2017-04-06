package com.anyikang.remote.client;

import com.anyikang.components.zookeeper.RegistryPath;
import com.anyikang.components.zookeeper.ServiceConsumer;
import com.anyikang.remote.server.service.ReportRMIService;
import com.anyikang.remote.server.service.SendConfigurationRMIService;

public class RemoteClient {
	public static void main(String[] args) throws Exception {
//		ServiceConsumer consumer = new ServiceConsumer(RegistryPath.ZK_REPORT);
		ServiceConsumer consumer = new ServiceConsumer(RegistryPath.ZK_SEND_CONFIGURATION);

//		ReportRMIService rmiService = consumer.lookup();
		SendConfigurationRMIService rmiService = consumer.lookup();
		String result = rmiService.sayHello("Jack");
		System.out.println(result);

	}
}
