/**
 * 
 */
package com.anyikang.remote.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author wangwei
 * @date 2017年4月1日
 */
public interface SendConfigurationRMIService extends Remote {

	// 继承 remote 接口表示接口用于远程调用
	// 必须让调用者补捉异常
	String sayHello(String imeiCode) throws RemoteException;
	
	/**
	 * 亲情号配置
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public boolean family(String name) throws RemoteException;

}
