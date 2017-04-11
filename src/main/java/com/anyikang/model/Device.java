/**
 * 
 */
package com.anyikang.model;

/**
 * @author wangwei
 * @date 2017年4月6日
 */
public class Device {

	private long id;
	private String name;
	private String imeiCode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImeiCode() {
		return imeiCode;
	}

	public void setImeiCode(String imeiCode) {
		this.imeiCode = imeiCode;
	}

}
