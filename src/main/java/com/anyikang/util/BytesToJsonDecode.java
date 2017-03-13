/**
 * 
 */
package com.anyikang.util;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * @author wangwei
 * @date 2017年3月7日
 */
public class BytesToJsonDecode extends ByteToMessageDecoder {

	/* (non-Javadoc)
	 * @see io.netty.handler.codec.ByteToMessageDecoder#decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List)
	 */
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		if(in.readableBytes()<10)
			return ;
		in.markReaderIndex();
		byte frameType = in.readByte();
		if (frameType==1||frameType==3||frameType==5||frameType==7||frameType==9)
		{
			byte frameSeq = in.readByte();
			short jsonLen = in.readShort();
			if(in.readableBytes()<jsonLen)
				in.resetReaderIndex();
			byte[] jsonBodyByte = new byte[jsonLen];
			in.readBytes(jsonBodyByte);
			String jsonBodyOri = new String(jsonBodyByte, "UTF-8");
			String jsonBody = CommonUtils.decodeFromBASE64(jsonBodyOri);
			
			JsonValidator jsonValidator = new JsonValidator();
			if (!jsonValidator.validate(jsonBody)) {
				messageError(ctx,"{\"errNo\":3}");
			}
			
			ByteToJsonBody messageBody = new ByteToJsonBody();
			messageBody.setFrameType(frameType);
			messageBody.setFrameSeq(frameSeq);
			messageBody.setJsonBody(jsonBody);
			out.add(messageBody);
		}
		else
		{
			messageError(ctx,"{\"errNo\":2}");
		}
		
	}
	
	
	private void messageError(final ChannelHandlerContext ctx,String returnMsg) {
		String message = returnMsg; 
		message = CommonUtils.encodeToBASE64(message);
		byte[] header = new byte[4];
		header[0]=(byte)1;
		header[1]=(byte)1;
		byte[] body = message.getBytes();
		byte[] aaa = CommonUtils.shortToByteArray((short)body.length);
		header[2] = aaa[0] ;
		header[3] = aaa[1] ;
		byte[] all = new byte[4+body.length];
		System.arraycopy(header, 0, all, 0, 4);
		System.arraycopy(body, 0, all, 4, body.length);

		ByteBuf encoded = ctx.alloc().buffer(all.length);  
		encoded.writeBytes(all);  
		ctx.writeAndFlush(encoded);
		ctx.channel().close();
		return;
	}

}
