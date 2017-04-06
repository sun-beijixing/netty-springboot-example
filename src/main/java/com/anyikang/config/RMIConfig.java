/**
 * 
 */
package com.anyikang.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangwei
 * @date 2017年4月6日
 */
@Component
@ConfigurationProperties(prefix = "spring.rmi")
public class RMIConfig {

	private String host;
	private int port1;
	private int port2;
	private int port3;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort1() {
		return port1;
	}

	public void setPort1(int port1) {
		this.port1 = port1;
	}

	public int getPort2() {
		return port2;
	}

	public void setPort2(int port2) {
		this.port2 = port2;
	}

	public int getPort3() {
		return port3;
	}

	public void setPort3(int port3) {
		this.port3 = port3;
	}

}
