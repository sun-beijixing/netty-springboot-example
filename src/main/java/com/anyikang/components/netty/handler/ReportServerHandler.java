/**
 * 
 */
package com.anyikang.components.netty.handler;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelHandler.Sharable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.components.netty.session.ChannelsSession;
import com.anyikang.components.netty.session.ChannelsSessionManager;
import com.anyikang.service.ReportService;

/**
 * @author wangwei
 * @date 2017年3月2日
 */
@Component
@Sharable
public class ReportServerHandler extends ChannelInboundHandlerAdapter {

	private final Logger logger = LoggerFactory.getLogger(ReportServerHandler.class);

	@Autowired
	private ChannelsSessionManager channelsSessionManager;
	@Autowired
	private ReportService functionService;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		// 定时任务
		// ScheduledExecutorService deviceUpgrade =
		// Executors.newScheduledThreadPool(3);
		// deviceUpgrade.scheduleWithFixedDelay(new
		// AutoCheckUpgradTimer(dataManager), 20, 60, TimeUnit.SECONDS);
		
	    channelsSessionManager.buildChannelsSession(ctx.channel());
	    
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {

		boolean isReturn = true;
		boolean isExist=true;

		ByteToJsonBody messageBody = (ByteToJsonBody) msg;
		JsonBodyToByte jb =null;

		switch (messageBody.getFunctionCode()) {
			case 0x00:// 心跳上报
				functionService.heartbeat(messageBody);
				isReturn = false;
				break;
			case 0x01:// 定位上报
				jb = functionService.positioning(messageBody);
				break;
			case 0x02:// 运动上报
				jb = functionService.exercise(messageBody);
				break;
			case 0x03:// 心率上报
				jb = functionService.heartRate(messageBody);
				break;
			case 0x04:// 血氧上报
				jb = functionService.bloodOxygen(messageBody);
				break;
			case 0x05:// 血压上报
				jb = functionService.bloodPressure(messageBody);
				break;
			case 0x06:// 睡眠上报
				jb = functionService.sleep(messageBody);
				break;
			default:
				ctx.fireChannelRead(msg);// 通知执行下一个InboundHandler
				isExist=false;
		}

		if (isReturn&&isExist) {
			jb.setBeginCode(0x68);
			jb.setImeiCode(messageBody.getImeiCode());
//			jb.setDataLength((byte)16);
//			jb.setFunctionCode((byte) 1);
//			jb.setDataNumber((byte) 10);
//			jb.setErrCode((byte) 0);
//			jb.setErrMsg("test");
			jb.setCrc((byte) 0x56);
			jb.setEndCode(0x16);

			ctx.writeAndFlush(jb);
		}

	}

	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("ReportServerHandler.channelReadComplete");

		// ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		ctx.close();
	}

}
