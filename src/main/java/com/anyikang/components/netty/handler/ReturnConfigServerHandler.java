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
import com.anyikang.service.ReturnConfigService;

/**
 * 终端响应信息处理
 * @author wangwei
 * @date 2017年3月2日
 */
@Component
@Sharable
public class ReturnConfigServerHandler extends ChannelInboundHandlerAdapter {
	
	private final Logger logger = LoggerFactory.getLogger(ReturnConfigServerHandler.class);

	@Autowired
	private ReturnConfigService configurationService;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ByteToJsonBody messageBody = (ByteToJsonBody) msg;
		
		switch (messageBody.getFunctionCode()) {
			case 0x10:// 时间配置响应
				configurationService.time(messageBody);
				break;
			case 0x11:// 定位配置
				configurationService.positioning(messageBody);
				break;
			case 0x12:// 电子围栏配置
				configurationService.electronicFence(messageBody);
				break;
			case 0x13:// 亲情号配置
				configurationService.family(messageBody);
				break;
			case 0x14:// 白名单配置
				configurationService.nameList(messageBody);
				break;
			case 0x15:// 运动配置
				configurationService.exercise(messageBody);
				break;
			case 0x16:// 心率配置
				configurationService.heartRate(messageBody);
				break;
			case 0x17:// IP配置
				configurationService.ip(messageBody);
				break;
			case 0x19:// 闹钟配置
				configurationService.clock(messageBody);
				break;
			case 0x1A:// wifi配置
				configurationService.wifi(messageBody);
				break;
			case 0x1B:// 提醒
				configurationService.warn(messageBody);
				break;
			case 0x1C:// 信息推送
				configurationService.informationPush(messageBody);
				break;
			case 0x1D:// 恢复出厂设置
				configurationService.factoryReset(messageBody);
				break;
			case 0x1E:// SOS配置
				configurationService.sos(messageBody);
				break;
			case 0x1F:// 跌倒配置
				configurationService.tumble(messageBody);
				break;
			default:
				ctx.fireChannelRead(msg);// 通知执行下一个InboundHandler
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
