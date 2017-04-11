/**
 * 
 */
package com.anyikang.components.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.service.HeartbeatService;

/**
 * Handler implementation for heart beating.
 * 
 * @author wangwei
 * @date 2017年3月7日
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
	
	private HeartbeatService heartbeatService;
	
	
	/**
	 * @param heartbeatService
	 */
	public HeartBeatHandler(HeartbeatService heartbeatService) {
		super();
		this.heartbeatService = heartbeatService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.netty.channel.ChannelInboundHandlerAdapter#channelRead(io.netty.channel
	 * .ChannelHandlerContext, java.lang.Object)
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		boolean isExist=true;

		ByteToJsonBody messageBody = (ByteToJsonBody) msg;
		
		JsonBodyToByte jb =null;
		
		switch (messageBody.getFunctionCode()) {
			case 0x00:// 心跳上报
				heartbeatService.heartbeatReport(messageBody);
				break;
			case 0x18:// 心跳配置
				jb = heartbeatService.heartbeatConfig(messageBody);
				break;	
			default:
				ctx.fireChannelRead(msg);// 通知执行下一个InboundHandler
				isExist=false;
		}
		
		if (isExist) {
			jb.setBeginCode(0x68);
			jb.setImeiCode(messageBody.getImeiCode());
			jb.setCrc((byte) 0x56);
			jb.setEndCode(0x16);

			ctx.writeAndFlush(jb);
		}
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent) evt;
			switch (event.state()) {
			case READER_IDLE:// 未读
				System.out.println("READER_IDLE");
				ctx.close();
				break;
			case WRITER_IDLE:// 未写
				System.out.println("WRITER_IDLE");
				ctx.writeAndFlush("ping");//心跳不用回应
				break;
			case ALL_IDLE:// 既未读也未写
				System.out.println("ALL_IDLE");

				// 发送心跳消息
				// ctx.writeAndFlush("ping");
				break;
			default:
				break;

			}
		}

	}

}