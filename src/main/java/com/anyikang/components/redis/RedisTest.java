/**
 * 
 */
package com.anyikang.components.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.anyikang.model.TestUser;
import com.anyikang.util.RedisUtils;

/**
 * @author wangwei
 * @date 2017年3月13日
 */
@Component
public class RedisTest {
	
	@Autowired  
    private RedisUtils redisUtil;
	
	@Scheduled(fixedDelay = 10000L)
	public void getSessionId() {  
        redisUtil.set("123", "测试");  
        System.out.println("-------------进入了方法");  
        String string = redisUtil.get("123").toString();  
        System.out.println("=============redis get:"+string);
        return ;  
    }  
	

	public TestUser getStudent() {  
    	TestUser user = new TestUser();  
        user.setId(001);  
        user.setAge(17);  
        user.setName("张三");  
        redisUtil.set("001", user);  
        return (TestUser) redisUtil.get("001");  
    }  
}
