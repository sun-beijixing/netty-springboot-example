//package com.anyikang.remote.client;
//
//import com.anyikang.components.zookeeper.RegistryPath;
//import com.anyikang.components.zookeeper.ServiceConsumer;
//import com.anyikang.remote.server.service.ReportRMIService;
//import com.anyikang.remote.server.service.ConfigRMIService;
//
//public class RemoteClient {
//	public static void main(String[] args) throws Exception {
//		ServiceConsumer consumer1 = new ServiceConsumer(RegistryPath.ZK_REPORT);
//		ReportRMIService rmiService1 = consumer1.lookup();
//		System.err.println(rmiService1.sayHello("Jack"));
//		
//		ServiceConsumer consumer2 = new ServiceConsumer(RegistryPath.ZK_SEND_CONFIGURATION);
//		ConfigRMIService rmiService2 = consumer2.lookup();
//		System.err.println(rmiService2.sayHello("xxx"));
//
//	}
//}
