/**
 * 
 */
package com.anyikang.components.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelHandler.Sharable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.components.netty.coding.ByteToJsonBody;
import com.anyikang.components.netty.coding.JsonBodyToByte;
import com.anyikang.service.ConfigurationService;

/**
 * 处理客户端发送到服务器的报文处理
 * @author wangwei
 * @date 2017年3月2日
 */
@Component
@Sharable
public class ConfigurationServerHandler extends ChannelInboundHandlerAdapter {
	
	private final Logger logger = LoggerFactory.getLogger(ConfigurationServerHandler.class);

	@Autowired
	private ConfigurationService configurationService;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		boolean isExist=true;

		ByteToJsonBody messageBody = (ByteToJsonBody) msg;
		
		JsonBodyToByte jb =null;

		switch (messageBody.getFunctionCode()) {
			case 0x10:// 时间配置
				jb = configurationService.time(messageBody);
				break;
			case 0x11:// 定位配置
				jb = configurationService.positioning(messageBody);
				break;
			case 0x12:// 电子围栏配置
				jb = configurationService.electronicFence(messageBody);
				break;
			case 0x13:// 亲情号配置
				jb = configurationService.family(messageBody);
				break;
			case 0x14:// 白名单配置
				jb = configurationService.nameList(messageBody);
				break;
			case 0x15:// 运动配置
				jb = configurationService.exercise(messageBody);
				break;
			case 0x16:// 心率配置
				jb = configurationService.heartRate(messageBody);
				break;
			case 0x17:// IP配置
				jb = configurationService.ip(messageBody);
				break;
			case 0x18:// 心跳配置
				jb = configurationService.heartbeat(messageBody);
				break;
			case 0x19:// 闹钟配置
				jb = configurationService.clock(messageBody);
				break;
			case 0x1A:// wifi配置
				jb = configurationService.wifi(messageBody);
				break;
			case 0x1B:// 提醒
				jb = configurationService.warn(messageBody);
				break;
			case 0x1C:// 信息推送
				jb = configurationService.informationPush(messageBody);
				break;
			case 0x1D:// 恢复出厂设置
				jb = configurationService.factoryReset(messageBody);
				break;
			case 0x1E:// SOS配置
				jb = configurationService.sos(messageBody);
				break;
			case 0x1F:// 跌倒配置
				jb = configurationService.tumble(messageBody);
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
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("ConfigurationServerHandler.channelReadComplete");  
//		ctx.flush();  
		 
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		ctx.close();
	}  

	
	
}
