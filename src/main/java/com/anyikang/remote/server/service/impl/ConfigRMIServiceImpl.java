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
import com.anyikang.remote.server.service.ConfigRMIService;
import com.anyikang.util.RedisUtils;

/**
 * @author wangwei
 * @date 2017年4月1日
 */
@Service
public class ConfigRMIServiceImpl  extends UnicastRemoteObject implements ConfigRMIService {

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
	public ConfigRMIServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.anyikang.remote.server.service.ConfigRMIService#time(java.lang.String)
	 */
	@Override
	public boolean time(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#positioning(java.lang.String)
	 */
	@Override
	public boolean positioning(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#electronicFence(java.lang.String)
	 */
	@Override
	public boolean electronicFence(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#family(java.lang.String)
	 */
	@Override
	public boolean family(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#exercise(java.lang.String)
	 */
	@Override
	public boolean exercise(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#nameList(java.lang.String)
	 */
	@Override
	public boolean nameList(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#heartRate(java.lang.String)
	 */
	@Override
	public boolean heartRate(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#ip(java.lang.String)
	 */
	@Override
	public boolean ip(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#clock(java.lang.String)
	 */
	@Override
	public boolean clock(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#wifi(java.lang.String)
	 */
	@Override
	public boolean wifi(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#warn(java.lang.String)
	 */
	@Override
	public boolean warn(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#informationPush(java.lang.String)
	 */
	@Override
	public boolean informationPush(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#factoryReset(java.lang.String)
	 */
	@Override
	public boolean factoryReset(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#sos(java.lang.String)
	 */
	@Override
	public boolean sos(String imeiCode) throws RemoteException {
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
	 * @see com.anyikang.remote.server.service.ConfigRMIService#tumble(java.lang.String)
	 */
	@Override
	public boolean tumble(String imeiCode) throws RemoteException {
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

	
	
	

}
