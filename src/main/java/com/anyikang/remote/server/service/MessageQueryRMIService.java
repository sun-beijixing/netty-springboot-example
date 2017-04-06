/**
 * 
 */
package com.anyikang.remote.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author wangwei
 * @date 2017年4月6日
 */
public interface MessageQueryRMIService extends Remote {
	// 继承 remote 接口表示接口用于远程调用
	// 必须让调用者补捉异常
	String sayHello(String name) throws RemoteException;

	public void time(String sessionId) throws RemoteException;
}
