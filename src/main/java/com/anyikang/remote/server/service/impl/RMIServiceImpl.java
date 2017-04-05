package com.anyikang.remote.server.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.stereotype.Service;

import com.anyikang.remote.server.service.HelloService;

@Service
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9143476214591382964L;

    /**
	 * @throws RemoteException
	 */
	public HelloServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
    public String sayHello(String name) throws RemoteException {
        return String.format("Hello %s", name);
    }
}
