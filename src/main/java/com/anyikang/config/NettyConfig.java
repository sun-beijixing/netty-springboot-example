
package com.anyikang.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.anyikang.netty.ChannelRepository;

/**
 * @author wangwei
 * @date 2017年3月1日
 */
@Component
@ConfigurationProperties(prefix = "spring.netty")
public class NettyConfig {

    private int tcpPort;
    private String tcpHost;
    private int bossCount;//用于分配处理业务线程的线程组个数
    private int workerCount;//业务出现线程大小,内核为此套接口排队的最大连接个数，对于给定的监听套接口，内核要维护两个队列，未链接队列和已连接队列大小总和最大值
    private boolean keepalive;
    private int backlog;


    @Bean(name = "channelRepository")
    public ChannelRepository channelRepository() {
        return new ChannelRepository();
    }

	/**
	 * @return the tcpPort
	 */
	public int getTcpPort() {
		return tcpPort;
	}

	/**
	 * @param tcpPort the tcpPort to set
	 */
	public void setTcpPort(int tcpPort) {
		this.tcpPort = tcpPort;
	}

	/**
	 * @return the tcpHost
	 */
	public String getTcpHost() {
		return tcpHost;
	}

	/**
	 * @param tcpHost the tcpHost to set
	 */
	public void setTcpHost(String tcpHost) {
		this.tcpHost = tcpHost;
	}

	/**
	 * @return the bossCount
	 */
	public int getBossCount() {
		return bossCount;
	}

	/**
	 * @param bossCount the bossCount to set
	 */
	public void setBossCount(int bossCount) {
		this.bossCount = bossCount;
	}

	/**
	 * @return the workerCount
	 */
	public int getWorkerCount() {
		return workerCount;
	}

	/**
	 * @param workerCount the workerCount to set
	 */
	public void setWorkerCount(int workerCount) {
		this.workerCount = workerCount;
	}

	/**
	 * @return the keepalive
	 */
	public boolean isKeepalive() {
		return keepalive;
	}

	/**
	 * @param keepalive the keepalive to set
	 */
	public void setKeepalive(boolean keepalive) {
		this.keepalive = keepalive;
	}

	/**
	 * @return the backlog
	 */
	public int getBacklog() {
		return backlog;
	}

	/**
	 * @param backlog the backlog to set
	 */
	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}

	
    
    

}
