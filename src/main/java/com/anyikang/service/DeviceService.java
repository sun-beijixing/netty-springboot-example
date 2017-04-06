/**
 * 
 */
package com.anyikang.service;

import java.util.List;

import com.anyikang.model.Device;

/**
 * @author wangwei
 * @date 2017年4月6日
 */
public interface DeviceService {
	
	public int addDevice(Device device);
	
	public List<Device> getDevices();

}
