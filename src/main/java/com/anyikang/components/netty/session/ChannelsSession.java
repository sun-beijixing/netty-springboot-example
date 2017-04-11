/**
 * 
 */
package com.anyikang.components.netty.session;

import io.netty.channel.ChannelId;

import java.io.Serializable;

/**
 * @author wangwei
 * @date 2017年4月1日
 */
public class ChannelsSession implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5379899806534062061L;
	// Session的唯一标识
	private ChannelId channelId;
	private String imeiCode;

	public ChannelId getChannelId() {
		return channelId;
	}

	public void setChannelId(ChannelId channelId) {
		this.channelId = channelId;
	}

	public String getImeiCode() {
		return imeiCode;
	}

	public void setImeiCode(String imeiCode) {
		this.imeiCode = imeiCode;
	}

	// 上次通信时间
	// private long lastCommunicateTimeStamp = 0l;

}