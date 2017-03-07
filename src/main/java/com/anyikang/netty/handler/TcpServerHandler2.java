/**
 * 
 */
package com.anyikang.netty.handler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anyikang.model.ObjectRequest;
import com.anyikang.model.ObjectRespone;
import com.anyikang.netty.server.NettyServer;

/**
 * @author wangwei
 * @date 2017年3月2日
 */
public class TcpServerHandler2 extends ChannelInboundHandlerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(TcpServerHandler2.class);  
	
	
	
	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelActive(io.netty.channel.ChannelHandlerContext)
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		// 定时任务
//        ScheduledExecutorService deviceUpgrade = Executors.newScheduledThreadPool(3);
//        deviceUpgrade.scheduleWithFixedDelay(new AutoCheckUpgradTimer(dataManager), 20, 60, TimeUnit.SECONDS);
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelRead(io.netty.channel.ChannelHandlerContext, java.lang.Object)
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		if(msg instanceof String){
			logger.info("=================String类型数据：");
			
			 ctx.writeAndFlush("server send msg:"+msg);    // 反馈消息  
		}else {
			logger.info("=================其他类型数据：");
			
			ObjectRequest req = (ObjectRequest)msg;  
			
			ObjectRespone resp = new ObjectRespone();  
			resp.setId(555666);  
			resp.setCode(0);  
			resp.setDesc("test ---");  
			ctx.writeAndFlush(resp);    // 反馈消息  
		}
		
		logger.info("服务器端接收的数据:"+msg);  
		
		// 通知执行下一个InboundHandler  
//		ctx.fireChannelRead(msg);
		
//		ctx.channel().write("server send msg:"+msg);
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelReadComplete(io.netty.channel.ChannelHandlerContext)
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("TcpServerHandler2.channelReadComplete");  
		
//		ctx.flush(); 
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#exceptionCaught(io.netty.channel.ChannelHandlerContext, java.lang.Throwable)
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
//		 ctx.close();
	}  

	
	
}
