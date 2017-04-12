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
import com.anyikang.remote.server.service.MessageQueryRMIService;

/**
 * @author wangwei
 * @date 2017年4月6日
 */
@Service
public class MessageQueryRMIServiceImpl extends UnicastRemoteObject implements MessageQueryRMIService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2854571269406827422L;
	
	
	@Autowired
	@Qualifier("channelGroup")
	private ChannelGroup channelGroup;
	@Autowired
	private ChannelsSessionManager channelsSessionManager;
	
	/**
	 * @throws RemoteException
	 */
	protected MessageQueryRMIServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.MessageQueryRMIService#queryVersionCode(java.lang.String)
	 */
	@Override
	public boolean versionCode(String imeiCode) throws RemoteException {
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
		return true;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.MessageQueryRMIService#positioning(java.lang.String)
	 */
	@Override
	public boolean positioning(String imeiCode) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.MessageQueryRMIService#exercise(java.lang.String)
	 */
	@Override
	public boolean exercise(String imeiCode) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.MessageQueryRMIService#heartRate(java.lang.String)
	 */
	@Override
	public boolean heartRate(String imeiCode) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.MessageQueryRMIService#bloodOxygen(java.lang.String)
	 */
	@Override
	public boolean bloodOxygen(String imeiCode) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.MessageQueryRMIService#bloodPressure(java.lang.String)
	 */
	@Override
	public boolean bloodPressure(String imeiCode) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.MessageQueryRMIService#sleep(java.lang.String)
	 */
	@Override
	public boolean sleep(String imeiCode) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.MessageQueryRMIService#lost(java.lang.String)
	 */
	@Override
	public boolean lost(String imeiCode) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
