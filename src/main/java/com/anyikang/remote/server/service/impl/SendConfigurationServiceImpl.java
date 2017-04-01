/**
 * 
 */
package com.anyikang.remote.server.service.impl;

import io.netty.channel.Channel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.components.netty.session.ChannelsSession;
import com.anyikang.components.netty.session.ChannelsSessionManager;
import com.anyikang.remote.server.service.SendConfigurationService;

/**
 * @author wangwei
 * @date 2017年4月1日
 */
@Service
public class SendConfigurationServiceImpl  extends UnicastRemoteObject implements SendConfigurationService {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2262426771675940019L;
	
	@Autowired
	private ChannelsSessionManager channelsSessionManager;

	/**
	 * @throws RemoteException
	 */
	public SendConfigurationServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.SendConfigurationService#time()
	 */
	@Override
	public void time(String sessionId) throws RemoteException {
		ChannelsSession channelsSession=channelsSessionManager.findById(sessionId);
		System.err.println("channelsSession:"+channelsSession);
		Channel channel=channelsSession.getChannel();
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
	}
	
	

}
