package com.anyikang.remote.server.service.impl;

import io.netty.channel.Channel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.components.netty.session.ChannelsSession;
import com.anyikang.components.netty.session.ChannelsSessionManager;
import com.anyikang.remote.server.service.ReportRMIService;

@Service
public class ReportRMIServiceImpl extends UnicastRemoteObject implements ReportRMIService {
	
	@Autowired
	private ChannelsSessionManager channelsSessionManager;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9143476214591382964L;

	
    /**
	 * @throws RemoteException
	 */
	public ReportRMIServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
    public String sayHello(String name) throws RemoteException {
        return String.format("Hello %s", name);
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
