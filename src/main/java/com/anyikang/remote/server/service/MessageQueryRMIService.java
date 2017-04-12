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

	/**
	 * 版本号查询
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public boolean versionCode(String imeiCode) throws RemoteException;

	/**
	 * 定位信息查询
	 * 
	 * @param messageBody
	 */
	public boolean positioning(String imeiCode) throws RemoteException;

	/**
	 * 运动信息查询
	 * 
	 * @param messageBody
	 */
	public boolean exercise(String imeiCode) throws RemoteException;

	/**
	 * 心率信息查询
	 * 
	 * @param messageBody
	 */
	public boolean heartRate(String imeiCode) throws RemoteException;

	/**
	 * 血氧信息查询
	 * 
	 * @param messageBody
	 */
	public boolean bloodOxygen(String imeiCode) throws RemoteException;

	/**
	 * 血压信息查询
	 * 
	 * @param messageBody
	 */
	public boolean bloodPressure(String imeiCode) throws RemoteException;

	/**
	 * 睡眠信息查询
	 * 
	 * @param messageBody
	 */
	public boolean sleep(String imeiCode) throws RemoteException;

	/**
	 * 丢失报文查询
	 * 
	 * @param messageBody
	 */
	public boolean lost(String imeiCode) throws RemoteException;

}
