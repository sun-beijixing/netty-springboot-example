/**
 * 
 */
package com.anyikang.components.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Handler implementation for heart beating.
 * 
 * @author wangwei
 * @date 2017年3月7日
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
	
	
	

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelRead(io.netty.channel.ChannelHandlerContext, java.lang.Object)
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		// TODO Auto-generated method stub
		super.channelRead(ctx, msg);
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent) evt;
			switch (event.state()) {
			case READER_IDLE://未读
				System.out.println("READER_IDLE");
				ctx.close();
				break;
			case WRITER_IDLE://未写
				System.out.println("WRITER_IDLE");
				ctx.writeAndFlush("ping");
				break;
			case ALL_IDLE://既未读也未写
				System.out.println("ALL_IDLE");
				
                // 发送心跳消息  
//				ctx.writeAndFlush("ping");
				break;
			default:
				break;

			}
		}

	}

}