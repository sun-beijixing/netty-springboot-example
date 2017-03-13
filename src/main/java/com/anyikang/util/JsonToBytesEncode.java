/**
 * 
 */
package com.anyikang.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author wangwei
 * @date 2017年3月7日
 */
public class JsonToBytesEncode extends MessageToByteEncoder<JsonBodyToByte>{

	/* (non-Javadoc)
	 * @see io.netty.handler.codec.MessageToByteEncoder#encode(io.netty.channel.ChannelHandlerContext, java.lang.Object, io.netty.buffer.ByteBuf)
	 */
	@Override
	protected void encode(ChannelHandlerContext ctx, JsonBodyToByte msg,
			ByteBuf out) throws Exception {
		JsonBodyToByte jsonBodyToByte =(JsonBodyToByte)msg;
		byte[] base64String = CommonUtils.encodeToBASE64(jsonBodyToByte.getJsonBody()).getBytes();
		
		out.writeByte(jsonBodyToByte.getFrameType());
		out.writeByte(jsonBodyToByte.getFrameSeq());
		out.writeShort(base64String.length);
		out.writeBytes(base64String);
		
	}

}
