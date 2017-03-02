/**
 * 
 */
package com.anyikang.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangwei
 * @date 2017年3月2日
 */
public class TcpServerHandler2 extends ChannelInboundHandlerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(TcpServerHandler1.class);

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelRead(io.netty.channel.ChannelHandlerContext, java.lang.Object)
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		logger.info("==================server handler2 receive msg:"+msg);  
		
		// 通知执行下一个InboundHandler  
//		ctx.fireChannelRead(msg);
		
		ctx.channel().write("server handler2 receive msg:"+msg);
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelReadComplete(io.netty.channel.ChannelHandlerContext)
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		logger.info("InboundHandler1.channelReadComplete");  
		ctx.flush();  
		 
	}  

	
	
}
