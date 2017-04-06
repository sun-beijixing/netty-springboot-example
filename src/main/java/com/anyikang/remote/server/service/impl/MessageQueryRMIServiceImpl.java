/**
 * 
 */
package com.anyikang.remote.server.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.stereotype.Service;

import com.anyikang.remote.server.service.MessageQueryRMIService;

/**
 * @author wangwei
 * @date 2017年4月6日
 */
@Service
public class MessageQueryRMIServiceImpl extends UnicastRemoteObject implements MessageQueryRMIService {

	/**
	 * @throws RemoteException
	 */
	protected MessageQueryRMIServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2854571269406827422L;

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.MessageQueryRMIService#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) throws RemoteException {
		return String.format("Hello %s", name);
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.MessageQueryRMIService#time(java.lang.String)
	 */
	@Override
	public void time(String sessionId) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
