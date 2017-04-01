/**
 * 
 */
package com.anyikang.components.netty.session;


import java.io.Serializable;
import java.net.SocketAddress;

import org.springframework.stereotype.Component;

import io.netty.channel.Channel;

/**
 * @author wangwei
 * @date 2017年4月1日
 */
public class ChannelsSession implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5379899806534062061L;
	//Session的唯一标识
    private String id;
    //和Session相关的channel,通过它向客户端回送数据
    private Channel channel = null;
    //上次通信时间
    private long lastCommunicateTimeStamp = 0l;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public long getLastCommunicateTimeStamp() {
		return lastCommunicateTimeStamp;
	}

	public void setLastCommunicateTimeStamp(long lastCommunicateTimeStamp) {
		this.lastCommunicateTimeStamp = lastCommunicateTimeStamp;
	}

	
    
}