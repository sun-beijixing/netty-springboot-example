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
import com.anyikang.service.MessageQueryService;

/**
 * @author wangwei
 * @date 2017年3月30日
 */
@Component
@Sharable
public class MessageQueryServerHandler extends ChannelInboundHandlerAdapter {
	
	private final Logger logger = LoggerFactory.getLogger(MessageQueryServerHandler.class);

	@Autowired
	private MessageQueryService messageQueryService;

	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {

		boolean isReturn = true;

		String returnMessage = "";

		ByteToJsonBody messageBody = (ByteToJsonBody) msg;

		switch (messageBody.getFunctionCode()) {
			case 0x30:// 版本查询
				returnMessage = messageQueryService.versions(messageBody);
				break;
			case 0x31:// 定位信息查询
				returnMessage = messageQueryService.positioning(messageBody);
				break;
			case 0x32:// 运动信息查询
				returnMessage = messageQueryService.exercise(messageBody);
				break;
			case 0x33:// 心率信息查询
				returnMessage = messageQueryService.heartRate(messageBody);
				break;
			case 0x34:// 血氧信息查询
				returnMessage = messageQueryService.bloodOxygen(messageBody);
				break;
			case 0x35:// 血压信息查询
				returnMessage = messageQueryService.bloodPressure(messageBody);
				break;
			case 0x36:// 睡眠信息查询
				returnMessage = messageQueryService.sleep(messageBody);
				break;
			case 0x37:// 丢失报文查询
				returnMessage = messageQueryService.lost(messageBody);
				break;
			default:
				messageError(ctx);
		}

		if (isReturn) {
			JsonBodyToByte jsonBodyToByte = new JsonBodyToByte();
			jsonBodyToByte.setBeginCode((byte) 64);
			jsonBodyToByte.setImeiCode("11111111");
			jsonBodyToByte.setDataLength((byte) 20);
			jsonBodyToByte.setFunctionCode((byte) 1);
			jsonBodyToByte.setDataNumber((byte) 10);
			jsonBodyToByte.setErrCode((byte) 0);
			jsonBodyToByte.setErrMsg("test");
			jsonBodyToByte.setCrc((byte) 2);
			jsonBodyToByte.setEndCode((byte) 16);

			ctx.writeAndFlush(jsonBodyToByte);
		}

		// 通知执行下一个InboundHandler
//		 ctx.fireChannelRead(msg);

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
