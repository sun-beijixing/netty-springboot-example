package com.anyikang.remote.server.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.anyikang.remote.server.service.HelloService;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
	

    /**
	 * @throws RemoteException
	 */
	public HelloServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9143476214591382964L;

	@Override
    public String sayHello(String name) throws RemoteException {
        return String.format("Hello %s", name);
    }
}
