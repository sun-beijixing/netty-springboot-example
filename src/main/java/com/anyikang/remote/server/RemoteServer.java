package com.anyikang.remote.server;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.components.zookeeper.RegistryPath;
import com.anyikang.components.zookeeper.ServiceProvider;
import com.anyikang.config.RMIConfig;
import com.anyikang.remote.server.service.MessageQueryRMIService;
import com.anyikang.remote.server.service.ReportRMIService;
import com.anyikang.remote.server.service.SendConfigurationRMIService;

@Component
public class RemoteServer {
	
	private final Logger logger = LoggerFactory.getLogger(RemoteServer.class);
	
	@Autowired
	private RMIConfig rmiConfig;
	@Autowired
	private ReportRMIService reportRMIService;
	@Autowired
	private MessageQueryRMIService messageQueryRMIService;
	@Autowired
	private SendConfigurationRMIService sendConfigurationRMIService;
	@Autowired
	private ServiceProvider serviceProvider;
	
	
	/**
     * 启动RMI服务
     * @throws Exception
     */
    @PostConstruct
    public void startRMI() throws Exception {
        logger.info("================开始启动RMI服务=================");
    	
		serviceProvider.publish(reportRMIService, rmiConfig.getHost(), rmiConfig.getPort1(),RegistryPath.ZK_REPORT);
		serviceProvider.publish(sendConfigurationRMIService, rmiConfig.getHost(), rmiConfig.getPort2(),RegistryPath.ZK_SEND_CONFIGURATION);
		serviceProvider.publish(messageQueryRMIService, rmiConfig.getHost(), rmiConfig.getPort3(),RegistryPath.ZK_MESSAGE_QUERY);
    }
	
}
