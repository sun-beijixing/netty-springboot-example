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
public interface ConfigRMIService extends Remote {

	/**
	 * 时间配置
	 * 
	 * @param messageBody
	 */
	public boolean time(String imeiCode) throws RemoteException;

	/**
	 * 定位配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean positioning(String imeiCode) throws RemoteException;

	/**
	 * 电子围栏配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean electronicFence(String imeiCode) throws RemoteException;

	/**
	 * 亲情号配置
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	public boolean family(String imeiCode) throws RemoteException;

	/**
	 * 运动配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean exercise(String imeiCode) throws RemoteException;

	/**
	 * 白名单配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean nameList(String imeiCode) throws RemoteException;

	/**
	 * 心率配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean heartRate(String imeiCode) throws RemoteException;

	/**
	 * IP配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean ip(String imeiCode) throws RemoteException;

	/**
	 * 闹钟配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean clock(String imeiCode) throws RemoteException;

	/**
	 * wifi配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean wifi(String imeiCode) throws RemoteException;

	/**
	 * 提醒配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean warn(String imeiCode) throws RemoteException;

	/**
	 * 信息推送配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean informationPush(String imeiCode) throws RemoteException;

	/**
	 * 恢复出厂配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean factoryReset(String imeiCode) throws RemoteException;

	/**
	 * sos配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean sos(String imeiCode) throws RemoteException;

	/**
	 * 跌倒配置
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean tumble(String imeiCode) throws RemoteException;

}
