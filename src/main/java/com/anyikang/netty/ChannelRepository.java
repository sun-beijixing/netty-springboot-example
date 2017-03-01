
package com.anyikang.netty;

import io.netty.channel.Channel;

import java.util.HashMap;


/**
 * Channel Repository using HashMap
 * @author wangwei
 * @date 2017年3月1日
 */
public class ChannelRepository {
    private HashMap<String, Channel> channelCache = new HashMap<String, Channel>();

    public ChannelRepository put(String key, Channel value) {
        channelCache.put(key, value);
        return this;
    }

    public Channel get(String key) {
        return channelCache.get(key);
    }

    public void remove(String key) { this.channelCache.remove(key); }

    public int size() {
        return this.channelCache.size();
    }
}
