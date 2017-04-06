/**
 * 
 */
package com.anyikang.remote.server.service.impl;

import io.netty.channel.Channel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.components.netty.session.ChannelsSession;
import com.anyikang.components.netty.session.ChannelsSessionManager;
import com.anyikang.remote.server.service.SendConfigurationRMIService;

/**
 * @author wangwei
 * @date 2017年4月1日
 */
@Service
public class SendConfigurationRMIServiceImpl  extends UnicastRemoteObject implements SendConfigurationRMIService {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2262426771675940019L;
	
	@Autowired
	private ChannelsSessionManager channelsSessionManager;

	/**
	 * @throws RemoteException
	 */
	public SendConfigurationRMIServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.SendConfigurationRMIService#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) throws RemoteException {
		return String.format("Hello %s", name);
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.SendConfigurationRMIService#family(java.lang.String)
	 */
	@Override
	public boolean family(String name) throws RemoteException {
		System.out.println("===亲情号配置===");
		return true;
	}
	
	

}
