/**
 * 
 */
package com.anyikang.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.anyikang.Application;
import com.anyikang.components.netty.session.ChannelsSession;
import com.anyikang.service.ConfigurationService;
import com.anyikang.service.impl.ConfigurationServiceImpl;



/**
 * @author wangwei
 * @date 2017年4月10日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
    private RedisTemplate<String, ChannelsSession> redisTemplate;
	@Autowired
	private ConfigurationService configurationService;

	@Test
	public void contextLoads() {
//		ChannelsSession channelsSession=new ChannelsSession();
////    	channelsSession.setId("xxx111");//此处暂且使用netty生成的类似UUID的字符串,来标识一个session
////    	channelsSession.setChannel(channel);
//    	
////    	channelsSession.setLastCommunicateTimeStamp(System.currentTimeMillis());
//    	
////    	redisUtils.set(channel.id().asLongText(), SerializationUtil.serialize(channelsSession));
//    	redisTemplate.opsForValue().set(channelsSession.getId(), channelsSession);
//    	
//    	
//    	ChannelsSession sss=redisTemplate.opsForValue().get(channelsSession.getId());
//    	System.out.println(sss.getId()+"=====================");
	}
}
