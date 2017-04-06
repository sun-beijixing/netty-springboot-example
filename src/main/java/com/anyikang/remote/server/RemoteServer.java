package com.anyikang.remote.server;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.components.zookeeper.RegistryPath;
import com.anyikang.components.zookeeper.ServiceProvider;
import com.anyikang.remote.server.service.MessageQueryRMIService;
import com.anyikang.remote.server.service.ReportRMIService;
import com.anyikang.remote.server.service.SendConfigurationRMIService;
import com.anyikang.remote.server.service.impl.ReportRMIServiceImpl;

@Component
public class RemoteServer {
	
	private final Logger logger = LoggerFactory.getLogger(RemoteServer.class);
	
	@Autowired
	private ReportRMIService reportRMIService;
	@Autowired
	private MessageQueryRMIService messageQueryRMIService;
	@Autowired
	private SendConfigurationRMIService sendConfigurationRMIService;
	
	
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
		provider.publish(reportRMIService, host, port,RegistryPath.ZK_REPORT);
		provider.publish(sendConfigurationRMIService, host, 1097,RegistryPath.ZK_SEND_CONFIGURATION);
		provider.publish(messageQueryRMIService, host, 1099,RegistryPath.ZK_MESSAGE_QUERY);
		System.out.println("发布服务到zookeeper中");
    }
	
	
	
	
//	public static void main(String[] args) throws Exception {
//		
//		
//		ReportRMIService rmiService = new ReportRMIServiceImpl();
//		
////		String host = "localhost";
//		String host = "192.168.1.104";
//		int port = 1098;
//		ServiceProvider provider = new ServiceProvider();
//		provider.publish(rmiService, host, port);
//		System.out.println("发布服务到zookeeper中");
//
////		Thread.sleep(Long.MAX_VALUE);
//	}
}
