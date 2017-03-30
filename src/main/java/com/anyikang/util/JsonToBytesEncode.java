/**
 * 
 */
package com.anyikang.util;

import org.springframework.stereotype.Component;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author wangwei
 * @date 2017年3月7日
 */
@Component
public class JsonToBytesEncode extends MessageToByteEncoder<JsonBodyToByte>{

	/* (non-Javadoc)
	 * @see io.netty.handler.codec.MessageToByteEncoder#encode(io.netty.channel.ChannelHandlerContext, java.lang.Object, io.netty.buffer.ByteBuf)
	 */
	@Override
	protected void encode(ChannelHandlerContext ctx, JsonBodyToByte msg,ByteBuf out) throws Exception {
		JsonBodyToByte jsonBodyToByte =(JsonBodyToByte)msg;
//		byte[] base64String = CommonUtils.encodeToBASE64(jsonBodyToByte.getJsonBody()).getBytes();
		
//		out.writeShort(base64String.length);
//		out.writeBytes(base64String);
//		byte xxx=16;
//		out.writeBytes(base64String);
//		ctx.writeAndFlush(xxx);  
		
		// 将对象转化为字节数组  
//        byte[] bs = NettyCodeUtils.object2Bytes(null);  
//        // 将字节数组写入缓冲区  
//        out.writeBytes("1222".getBytes());  
        
        String ddd="WOW...";
		byte[] dd=ddd.getBytes();
		out.writeBytes(dd);  
		
		
        ctx.flush();  
		
	}
	
	

}
