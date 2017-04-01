/**
 * 
 */
package com.anyikang.components.netty.coding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anyikang.util.BCDUtils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 * @author wangwei
 * @date 2017年3月7日
 */
public class JsonToBytesEncode extends MessageToByteEncoder<JsonBodyToByte>{
	
	private final Logger logger = LoggerFactory.getLogger(JsonToBytesEncode.class);

	@Override
	protected void encode(ChannelHandlerContext ctx, JsonBodyToByte msg,ByteBuf out) throws Exception {
		JsonBodyToByte jb =(JsonBodyToByte)msg;
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
        
//        String ddd="WOW...";
//		byte[] dd=ddd.getBytes();
//		out.writeBytes(dd);  
		
		
		out.writeByte(jb.getBeginCode());
		out.writeBytes(BCDUtils.str2Bcd(jb.getImeiCode()));  
		out.writeByte(jb.getDataLength());
		out.writeByte(jb.getFunctionCode());
		if(jb.getServerType()==1){
			out.writeBytes(jb.getDataNumber());
		}else{
			
		}
		out.writeByte(jb.getErrCode());
		out.writeByte(jb.getErrMsg());
		out.writeByte(jb.getCrc());
		out.writeByte(jb.getEndCode());
        ctx.flush();  
		
	}
	
	
	
	

}
