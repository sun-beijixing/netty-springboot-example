/**
 * 
 */
package com.anyikang.remote.server.service.impl;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.components.netty.session.ChannelsSession;
import com.anyikang.components.netty.session.ChannelsSessionManager;
import com.anyikang.remote.server.service.SendConfigurationRMIService;
import com.anyikang.util.RedisUtils;

/**
 * @author wangwei
 * @date 2017年4月1日
 */
@Service
public class SendConfigurationRMIServiceImpl  extends UnicastRemoteObject implements SendConfigurationRMIService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2262426771675940019L;
	
	@Autowired
	@Qualifier("channelGroup")
	private ChannelGroup channelGroup;
	@Autowired  
	private RedisUtils redisUtils;
	@Autowired
	private ChannelsSessionManager channelsSessionManager;

	/**
	 * @throws RemoteException
	 */
	public SendConfigurationRMIServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.SendConfigurationRMIService#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String imeiCode) throws RemoteException {
		ChannelsSession channelsSession=channelsSessionManager.findById(imeiCode);
		Channel channel=channelGroup.find(channelsSession.getChannelId());
		
		JsonBodyToByte jb =new JsonBodyToByte();
		jb.setBeginCode(0x68);
		jb.setImeiCode("1111");
		jb.setDataLength((byte)16);
		jb.setFunctionCode((byte) 1);
		jb.setMark(0x01);
		jb.setErrCode((byte) 0);
		jb.setErrMsg((byte)0x01);
		jb.setCrc((byte) 0x56);
		jb.setEndCode(0x16);
		
		channel.writeAndFlush(jb);
		
		return String.format("imeiCode:", imeiCode);
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.SendConfigurationRMIService#family(java.lang.String)
	 */
	@Override
	public boolean family(String name) throws RemoteException {
		System.out.println("===亲情号配置===");
		return true;
	}
	
	

}
