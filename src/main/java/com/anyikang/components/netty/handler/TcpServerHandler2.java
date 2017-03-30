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
import org.springframework.stereotype.Component;

import com.anyikang.components.netty.server.NettyServer;
import com.anyikang.model.ObjectRequest;
import com.anyikang.model.ObjectRespone;
import com.anyikang.model.User;
import com.anyikang.service.ConfigurationService;
import com.anyikang.service.MessageQueryService;
import com.anyikang.service.ReportService;
import com.anyikang.service.UserService;
import com.anyikang.util.ByteToJsonBody;
import com.anyikang.util.JsonBodyToByte;

/**
 * @author wangwei
 * @date 2017年3月2日
 */
@Component
public class TcpServerHandler2 extends ChannelInboundHandlerAdapter {

	private final Logger logger = LoggerFactory.getLogger(TcpServerHandler2.class);

	@Autowired
	private ReportService functionService;
	@Autowired
	private ConfigurationService configurationService;
	@Autowired
	private MessageQueryService messageQueryService;

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

		if (msg instanceof String) {
			logger.info("=================String类型数据：");

			ctx.writeAndFlush("server send msg:" + msg); // 反馈消息
		} else {
			logger.info("=================其他类型数据：");

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
	//				messageError(ctx);
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
		}

		logger.info("服务器端接收的数据:" + msg);


		// 通知执行下一个InboundHandler
		// ctx.fireChannelRead(msg);

		// ctx.channel().write("server send msg:"+msg);
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
		logger.info("TcpServerHandler2.channelReadComplete");

		// ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		ctx.close();
	}

}
