/**
 * 
 */
package com.anyikang.components.netty.coding;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anyikang.util.BCDUtils;

/**
 * 解码器
 * @author wangwei
 * @date 2017年3月7日
 */
public class BytesToJsonDecode extends ByteToMessageDecoder {
	
	private final Logger logger = LoggerFactory.getLogger(BytesToJsonDecode.class);

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,List<Object> out) throws Exception {
		if(in.readableBytes()<20){//最基本长度
			return;
		}
		
		logger.debug("----------接收编码长度："+in.readableBytes());
		
		
		in.markReaderIndex();
		
		byte beginCode = in.readByte();
		//有可能是多条数据包，需要循环处理
		if (beginCode==0x68){
			String imeiCode=BCDUtils.byteToHexString(new byte[8],in);
			int dataLength=in.readByte();
			System.out.println("----------------dataLength:"+dataLength);
			
//			if(in.readableBytes()<dataLength){
//				logger.debug("=============接收的数据长度小于规定的数据长度================");
//				in.resetReaderIndex();
//				return;
//			}
			
			byte[] dataBody=new byte[dataLength];
			in.readBytes(dataBody);
			byte functionCode=dataBody[0];
//			String time=BCDUtils.byteToHexString(new byte[7],in);
			byte crc=in.readByte();
			byte endCode=in.readByte();
			
			if(endCode==0x16){
				ByteToJsonBody messageBody = new ByteToJsonBody();
				messageBody.setImeiCode(imeiCode);
				messageBody.setDataLength(dataLength);
				messageBody.setFunctionCode(functionCode);
				messageBody.setDataBody(dataBody);
//				messageBody.setTime(time);
				messageBody.setCrc(crc);
				out.add(messageBody);
			}
		}else{
			messageError(ctx,"格式错误");
		}
	}
	
	
	private void messageError(final ChannelHandlerContext ctx,String returnMsg) {
//		String message = returnMsg; 
//		message = CommonUtils.encodeToBASE64(message);
//		byte[] header = new byte[4];
//		header[0]=(byte)1;
//		header[1]=(byte)1;
//		byte[] body = message.getBytes();
//		byte[] aaa = CommonUtils.shortToByteArray((short)body.length);
//		header[2] = aaa[0] ;
//		header[3] = aaa[1] ;
//		byte[] all = new byte[4+body.length];
//		System.arraycopy(header, 0, all, 0, 4);
//		System.arraycopy(body, 0, all, 4, body.length);
//
//		ByteBuf encoded = ctx.alloc().buffer(all.length);  
//		encoded.writeBytes(all);  
//		ctx.writeAndFlush(encoded);
//		ctx.channel().close();
		return;
	}

}
