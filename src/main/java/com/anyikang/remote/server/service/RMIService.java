package com.anyikang.remote.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
	// 继承 remote 接口表示接口用于远程调用
	// 必须让调用者补捉异常
	String sayHello(String name) throws RemoteException;
}
