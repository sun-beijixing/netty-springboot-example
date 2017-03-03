/**
 * 
 */
package com.anyikang.netty.handler;

import com.anyikang.model.SubscribeReq;
import com.anyikang.model.SubscribeResp;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


  
/**
 * @author wangwei
 * @date 2017年3月3日
 */
public class SubReqServerHandler extends ChannelInboundHandlerAdapter{  
  
     
      
    /**
     * 读取客户端发来的数据
     */
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg)  
        throws Exception{  
          System.out.println("===================================mmmmmmm");
//          SubscribeReq reqx = new SubscribeReq();  
//          reqx.setAddress("*****深圳蛇口");  
//          reqx.setPhoneNumber("13888886666");  
//          reqx.setProductName("Netty Book");  
//          reqx.setSubReqID(6666);  
//          reqx.setUserName("XXYY");  
//          ctx.write(reqx);  
//          ctx.flush();  
          
          System.out.println("=============msg:"+msg);
//        
            SubscribeResp resp = new SubscribeResp();  
            resp.setnSubReqID(555666);  
            resp.setRespCode(0);  
            resp.setDesc("-------Netty book order succeed, 3days later, sent to the designated address");  
            ctx.writeAndFlush(resp);    // 反馈消息  
            //ctx.write(resp);  
            //ctx.flush();  
          
            SubscribeReq req = (SubscribeReq)msg;   // 订购内容  
//            if("XXYY".equalsIgnoreCase(req.getName())){  
                System.out.println("接收到的数据: [  " + req.toString() + "   ]");  
//            }  
              
    }  
      
    @Override  
    public  void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){  
        System.out.println("---------------exceptionCaught 网络异常，关闭网络");  
        cause.printStackTrace();  
        ctx.close();  
    }  
}  