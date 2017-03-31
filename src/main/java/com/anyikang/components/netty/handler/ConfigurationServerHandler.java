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
		boolean isReturn = true;
		boolean isExist=true;

		String returnMessage = "";

		ByteToJsonBody messageBody = (ByteToJsonBody) msg;

		switch (messageBody.getFunctionCode()) {
			case 0x10:// 时间配置
				returnMessage = configurationService.time(messageBody);
				break;
			case 0x11:// 定位配置
				returnMessage = configurationService.positioning(messageBody);
				break;
			case 0x12:// 电子围栏配置
				returnMessage = configurationService.electronicFence(messageBody);
				break;
			case 0x13:// 亲情号配置
				returnMessage = configurationService.family(messageBody);
				break;
			case 0x14:// 白名单配置
				returnMessage = configurationService.nameList(messageBody);
				break;
			case 0x15:// 运动配置
				returnMessage = configurationService.exercise(messageBody);
				break;
			case 0x16:// 心率配置
				returnMessage = configurationService.heartRate(messageBody);
				break;
			case 0x17:// IP配置
				returnMessage = configurationService.ip(messageBody);
				break;
			case 0x18:// 心跳配置
				returnMessage = configurationService.heartbeat(messageBody);
				break;
			case 0x19:// 闹钟配置
				returnMessage = configurationService.clock(messageBody);
				break;
			case 0x1A:// wifi配置
				returnMessage = configurationService.wifi(messageBody);
				break;
			case 0x1B:// 提醒
				returnMessage = configurationService.warn(messageBody);
				break;
			case 0x1C:// 信息推送
				returnMessage = configurationService.informationPush(messageBody);
				break;
			case 0x1D:// 恢复出厂设置
				returnMessage = configurationService.factoryReset(messageBody);
				break;
			case 0x1E:// SOS配置
				returnMessage = configurationService.sos(messageBody);
				break;
			case 0x1F:// 跌倒配置
				returnMessage = configurationService.tumble(messageBody);
				break;
			default:
				ctx.fireChannelRead(msg);// 通知执行下一个InboundHandler
				isExist=false;
//				messageError(ctx);
		}

		if (isReturn&&isExist) {
			JsonBodyToByte jsonBodyToByte = new JsonBodyToByte();
			jsonBodyToByte.setBeginCode((byte) 64);
			jsonBodyToByte.setImeiCode(messageBody.getImeiCode());
			jsonBodyToByte.setDataLength((byte) 20);
			jsonBodyToByte.setFunctionCode((byte) 1);
			jsonBodyToByte.setDataNumber((byte) 10);
			jsonBodyToByte.setErrCode((byte) 0);
			jsonBodyToByte.setErrMsg((byte) 0);
			jsonBodyToByte.setCrc((byte) 2);
			jsonBodyToByte.setEndCode((byte) 16);

			ctx.writeAndFlush(jsonBodyToByte);
		}

	}
	
	private void messageError(final ChannelHandlerContext ctx) {
		// String message = "{\"errNo\":2}";
		// message = CommonUtils.encodeToBASE64(message);
		// byte[] header = new byte[4];
		// header[0]=(byte)1;
		// header[1]=(byte)1;
		// byte[] body = message.getBytes();
		// byte[] aaa = CommonUtils.shortToByteArray((short)body.length);
		// header[2] = aaa[0] ;
		// header[3] = aaa[1] ;
		// byte[] all = new byte[4+body.length];
		// System.arraycopy(header, 0, all, 0, 4);
		// System.arraycopy(body, 0, all, 4, body.length);
		//
		// ByteBuf encoded = ctx.alloc().buffer(all.length);
		// encoded.writeBytes(all);
		// ctx.writeAndFlush(encoded);
		// log.error("异常信息:头信息格式错误");
		ctx.channel().close();
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
