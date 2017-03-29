/**
 * 
 */
package com.anyikang.components.netty.handler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.anyikang.components.netty.server.NettyServer;
import com.anyikang.model.HeartbeatMSG;
import com.anyikang.model.ObjectRequest;
import com.anyikang.model.ObjectRespone;
import com.anyikang.model.User;
import com.anyikang.service.UserService;
import com.anyikang.util.ByteToJsonBody;
import com.anyikang.util.JsonBodyToByte;

/**
 * @author wangwei
 * @date 2017年3月2日
 */
public class TcpServerHandler2 extends ChannelInboundHandlerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(TcpServerHandler2.class);  
	
	
	@Autowired
    private UserService userService;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		// 定时任务
//        ScheduledExecutorService deviceUpgrade = Executors.newScheduledThreadPool(3);
//        deviceUpgrade.scheduleWithFixedDelay(new AutoCheckUpgradTimer(dataManager), 20, 60, TimeUnit.SECONDS);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		if(msg instanceof String){
			logger.info("=================String类型数据：");
			
			 ctx.writeAndFlush("server send msg:"+msg);    // 反馈消息  
		}else {
			logger.info("=================其他类型数据：");
			
//			ObjectRequest req = (ObjectRequest)msg;  
//			
//			ObjectRespone resp = new ObjectRespone();  
//			resp.setId(555666);  
//			resp.setCode(0);  
//			resp.setDesc("test ---");  
//			ctx.writeAndFlush(resp);    // 反馈消息  
			
			ByteToJsonBody messageBody = (ByteToJsonBody)msg;
			
//			switch(messageBody.getFrameType())
//			{
//				case 1:
//					System.out.println("enter=================1");									
//					returnDevMessageBody = deviceConnectMainGateway(messageBody.getFrameSeq(), returnDevMessageHeader_one,originalMessageBody);
//					break;
//				default:
//					messageError(ctx);
//			}
			
			
			JsonBodyToByte jsonBodyToByte = new JsonBodyToByte();
			jsonBodyToByte.setBeginCode((byte)64);
			jsonBodyToByte.setImeiCode("11111111");
			jsonBodyToByte.setDataLength((byte)20);
			jsonBodyToByte.setFunctionCode((byte)1);
			jsonBodyToByte.setDataNumber((byte)10);
			jsonBodyToByte.setErrCode((byte)0);
			jsonBodyToByte.setErrMsg("test");
			jsonBodyToByte.setCrc((byte)2);
			jsonBodyToByte.setEndCode((byte)16);
			
			ctx.writeAndFlush(jsonBodyToByte);    // 反馈消息  
		}
		
		logger.info("服务器端接收的数据:"+msg);  
		
//		User user = userService.getUserInfo();
//        if(user!=null){
//            System.out.println("user.getName():"+user.getName());
//            logger.info("user.getAge():"+user.getAge());
//        }
		
		// 通知执行下一个InboundHandler  
//		ctx.fireChannelRead(msg);
		
//		ctx.channel().write("server send msg:"+msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("TcpServerHandler2.channelReadComplete");  
		
//		ctx.flush(); 
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		 ctx.close();
	}  

	
}
