/**
 * 
 */
package com.anyikang.components.netty.session;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author wangwei
 * @date 2017年4月1日
 */
@Component
public class ChannelsSessionManager {
	
	@Autowired
    private RedisTemplate<String, ChannelsSession> redisTemplate;
	
	/**
	 * 构建ChannelsSession
	 * @param channel
	 * @return
	 */
    public void buildChannelsSession(String imeiCode,ChannelId channelId) {
    	ChannelsSession channelsSession=new ChannelsSession();
    	channelsSession.setChannelId(channelId);//此处暂且使用netty生成的类似UUID的字符串,来标识一个session
    	channelsSession.setImeiCode(imeiCode);
//    	channelsSession.setLastCommunicateTimeStamp(System.currentTimeMillis());
    	
    	redisTemplate.opsForValue().set(imeiCode, channelsSession);//序列化有问题 ====================
        return;
    }
    
    /**
     * 构建ChannelsSession
     * @param channel
     * @return
     */
    public void unbuildChannelsSession(Channel channel) {
    	redisTemplate.delete(channel.id().toString());
    	return;
    }

    /**
     * 根据sessionid从redis内存中取出ChannelsSession
     * @param imeiCode
     * @return
     */
    public ChannelsSession findById(String imeiCode){
    	return redisTemplate.opsForValue().get(imeiCode);
    }
}
