/**
 * 
 */
package com.anyikang.components.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理客户端发送到服务器的报文处理
 * @author wangwei
 * @date 2017年3月2日
 */
public class TcpServerHandler1 extends ChannelInboundHandlerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(TcpServerHandler1.class);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		logger.info("==================server handler1 receive msg:"+msg);  
		
		// 通知执行下一个InboundHandler  
		ctx.fireChannelRead(msg);
		
		ctx.channel().write("server handler1 receive msg:"+msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		logger.info("InboundHandler1.channelReadComplete");  
		ctx.flush();  
		 
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#exceptionCaught(io.netty.channel.ChannelHandlerContext, java.lang.Throwable)
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
		
		ctx.close();
	}  

	
	
}
