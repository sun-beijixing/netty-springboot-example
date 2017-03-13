/**
 * 
 */
package client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anyikang.model.ObjectRequest;
import com.anyikang.model.ObjectRespone;
  
/**
 * @author wangwei
 * @date 2017年3月2日
 */
public class TcpClientHandler extends ChannelInboundHandlerAdapter {  
  
    private static final Logger logger = LoggerFactory.getLogger(TcpClientHandler.class);

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelActive(io.netty.channel.ChannelHandlerContext)
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelActive(ctx);
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelRead(io.netty.channel.ChannelHandlerContext, java.lang.Object)
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		// TODO Auto-generated method stub
		super.channelRead(ctx, msg);
		
		if(msg instanceof String){
			logger.info("=================String类型数据：");
			logger.info((String)msg);
			
			if(msg.equals("ping")){//测试心跳
				logger.info("----------------ok");
				ctx.writeAndFlush("ok");
			}
		}else {
			logger.info("=================其他类型数据：");
			ObjectRespone req = (ObjectRespone)msg;   // 订购内容  
			logger.info("客户端接收到的数据: [  " + req.toString() + "   ]");  
		}
		
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelReadComplete(io.netty.channel.ChannelHandlerContext)
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelReadComplete(ctx);
	}
  
  
}  