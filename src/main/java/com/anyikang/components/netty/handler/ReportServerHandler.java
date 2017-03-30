/**
 * 
 */
package com.anyikang.components.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.service.ReportService;
import com.anyikang.util.ByteToJsonBody;
import com.anyikang.util.JsonBodyToByte;

/**
 * @author wangwei
 * @date 2017年3月2日
 */
@Component
public class ReportServerHandler extends ChannelInboundHandlerAdapter {

	private final Logger logger = LoggerFactory.getLogger(ReportServerHandler.class);

	@Autowired
	private ReportService functionService;

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		// 定时任务
		// ScheduledExecutorService deviceUpgrade =
		// Executors.newScheduledThreadPool(3);
		// deviceUpgrade.scheduleWithFixedDelay(new
		// AutoCheckUpgradTimer(dataManager), 20, 60, TimeUnit.SECONDS);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {

		boolean isReturn = true;
		boolean isExist=true;

		String returnMessage = "";

		ByteToJsonBody messageBody = (ByteToJsonBody) msg;

		switch (messageBody.getFunctionCode()) {
			case 0x00:// 心跳上报
				functionService.heartbeat(messageBody);
				isReturn = false;
				break;
			case 0x01:// 定位上报
				returnMessage = functionService.positioning(messageBody);
				break;
			case 0x02:// 运动上报
				returnMessage = functionService.exercise(messageBody);
				break;
			case 0x03:// 心率上报
				returnMessage = functionService.heartRate(messageBody);
				break;
			case 0x04:// 血氧上报
				returnMessage = functionService.bloodOxygen(messageBody);
				break;
			case 0x05:// 血压上报
				returnMessage = functionService.bloodPressure(messageBody);
				break;
			case 0x06:// 睡眠上报
				returnMessage = functionService.sleep(messageBody);
				break;
			default:
				ctx.fireChannelRead(msg);// 通知执行下一个InboundHandler
				isExist=false;
//				messageError(ctx);
		}

		if (isReturn&&isExist) {
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
