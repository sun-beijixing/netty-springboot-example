
package com.anyikang.netty.init;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.anyikang.netty.RpcRequest;
import com.anyikang.netty.RpcResponse;
import com.anyikang.netty.codec.RpcDecoder;
import com.anyikang.netty.codec.RpcEncoder;


/**
 * Channel 初始化
 * @author wangwei
 * @date 2017年3月1日
 */
@Component
@Qualifier("somethingChannelInitializer")
public class SomethingChannelInitializer extends ChannelInitializer<SocketChannel> {

    private static final StringDecoder DECODER = new StringDecoder();
    private static final StringEncoder ENCODER = new StringEncoder();

    @Autowired
    @Qualifier("somethingServerHandler")
    private ChannelInboundHandlerAdapter somethingServerHandler;
    
    private Map<String, Object> exportServiceMap = new HashMap<String, Object>();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new DelimiterBasedFrameDecoder(1024*1024, Delimiters.lineDelimiter()));
        
        //第一种方式
        pipeline.addLast(DECODER);
        pipeline.addLast(ENCODER);
        pipeline.addLast(somethingServerHandler);//注册的业务逻辑
        
        //第二种方式
//        pipeline.addLast("decoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
//        pipeline.addLast("encoder", new LengthFieldPrepender(4, false));
//        pipeline.addLast(new RpcDecoder(RpcRequest.class));
//        pipeline.addLast(new RpcEncoder(RpcResponse.class));
//        pipeline.addLast(new ServerRpcHandler(exportServiceMap));
    }
}
