package com.anyikang.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangwei
 * @date 2017年2月17日
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

	private String host;

	private int port;

	private int timeout;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@Override
	public String toString() {
		return "Redis [localhost=" + host + ", port=" + port + ", timeout="
				+ timeout + "]";
	}

}