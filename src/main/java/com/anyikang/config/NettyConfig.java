
package com.anyikang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.anyikang.netty.ChannelRepository;

/**
 * @author wangwei
 * @date 2017年3月1日
 */
@Component
@PropertySource(value= "classpath:/properties/nettyserver.properties")
public class NettyConfig {
	

    @Value("${tcp.port}")
    private int tcpPort;
    
    @Value("${tcp.host}")
    private String tcpHost;

    @Value("${boss.thread.count}")
    private int bossCount;

    @Value("${worker.thread.count}")
    private int workerCount;//内核为此套接口排队的最大连接个数，对于给定的监听套接口，内核要维护两个队列，未链接队列和已连接队列大小总和最大值

    @Value("${so.keepalive}")
    private boolean keepAlive;

    @Value("${so.backlog}")
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
	 * @return the keepAlive
	 */
	public boolean isKeepAlive() {
		return keepAlive;
	}

	/**
	 * @param keepAlive the keepAlive to set
	 */
	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
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
