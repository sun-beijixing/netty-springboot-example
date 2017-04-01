/**
 * 
 */
package com.anyikang.components.netty.session;

import io.netty.channel.Channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.util.RedisUtils;
import com.anyikang.util.SerializationUtil;

/**
 * @author wangwei
 * @date 2017年4月1日
 */
@Component
public class ChannelsSessionManager {
	
	@Autowired  
	private RedisUtils redisUtils;  
	
	/**
	 * 构建ChannelsSession
	 * @param channel
	 * @return
	 */
    public void buildChannelsSession(Channel channel) {
    	ChannelsSession channelsSession=new ChannelsSession();
    	channelsSession.setId(channel.id().asLongText());//此处暂且使用netty生成的类似UUID的字符串,来标识一个session
    	channelsSession.setChannel(channel);
    	channelsSession.setLastCommunicateTimeStamp(System.currentTimeMillis());
    	//可以将channel.id().asLongText()或channel.id().asShortText()作为Session的ID
    	
    	redisUtils.set(channel.id().asLongText(), SerializationUtil.serialize(channelsSession));
        return;
    }

    /**
     * 根据sessionid从redis内存中取出ChannelsSession
     * @param sessionId
     * @return
     */
    public ChannelsSession findById(String sessionId){
        return (ChannelsSession) redisUtils.get(sessionId);
    }
}
