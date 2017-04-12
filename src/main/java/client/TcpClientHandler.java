///**
// * 
// */
//package client;
//
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInboundHandlerAdapter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//  
///**
// * @author wangwei
// * @date 2017年3月2日
// */
//public class TcpClientHandler extends ChannelInboundHandlerAdapter {  
//  
//    private static final Logger logger = LoggerFactory.getLogger(TcpClientHandler.class);
//
//	/* (non-Javadoc)
//	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelActive(io.netty.channel.ChannelHandlerContext)
//	 */
//	@Override
//	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		// TODO Auto-generated method stub
//		super.channelActive(ctx);
//	}
//
//	/* (non-Javadoc)
//	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelRead(io.netty.channel.ChannelHandlerContext, java.lang.Object)
//	 */
//	@Override
//	public void channelRead(ChannelHandlerContext ctx, Object msg)
//			throws Exception {
//		// TODO Auto-generated method stub
//		super.channelRead(ctx, msg);
//		
//		if(msg instanceof String){
//			logger.info("=================String类型数据：");
//			logger.info((String)msg);
//			
//			if(msg.equals("ping")){//测试心跳
//				logger.info("----------------ok");
//				ctx.writeAndFlush("ok");
//			}
//		}
//		
//	}
//
//	/* (non-Javadoc)
//	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelReadComplete(io.netty.channel.ChannelHandlerContext)
//	 */
//	@Override
//	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		// TODO Auto-generated method stub
//		super.channelReadComplete(ctx);
//	}
//  
//  
//}  