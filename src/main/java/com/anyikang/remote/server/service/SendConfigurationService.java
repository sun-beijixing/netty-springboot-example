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
public interface SendConfigurationService extends Remote {

	public void time(String sessionId) throws RemoteException;

}
