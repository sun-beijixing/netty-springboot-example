/**
 * 
 */
package com.anyikang.netty.handler;

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

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent) evt;
			switch (event.state()) {
			case READER_IDLE:
				// System.out.println("READER_IDLE: read timeout from "+ctx.channel().remoteAddress());
				// ctx.disconnect(); //Channel disconnect
				// 超时关闭channel
				ctx.close();
				System.out.println("READER_IDLE");
				break;
			case WRITER_IDLE:
				System.out.println("WRITER_IDLE");
				break;
			case ALL_IDLE:
				System.out.println("ALL_IDLE");
				break;
			default:
				break;

			}
		}

	}

}