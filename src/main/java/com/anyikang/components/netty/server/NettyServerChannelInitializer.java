/**
 * 
 */
package com.anyikang.components.netty.server;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.components.netty.handler.HeartBeatHandler;
import com.anyikang.components.netty.handler.TcpServerHandler2;
import com.anyikang.util.BytesToJsonDecode;
import com.anyikang.util.JsonToBytesEncode;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

/**
 * @author wangwei
 * @date 2017年3月7日
 */
@Component
public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel>{
	
	@Autowired
	private BytesToJsonDecode bytesToJsonDecode;
	@Autowired
	private JsonToBytesEncode jsonToBytesEncode;
	@Autowired
	private TcpServerHandler2 tcpServerHandler2;
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline=ch.pipeline();
                pipeline.addLast(bytesToJsonDecode);
                pipeline.addLast(jsonToBytesEncode);
                // 3 minutes for read idle
                //第一个参数是指定读操作空闲秒数，第二个参数是指定写操作的空闲秒数，第三个参数是指定读写空闲秒数，当有操作操作超出指定空闲秒数时，便会触发UserEventTriggered事件
                pipeline.addLast(new IdleStateHandler(8*60,5*60,0,TimeUnit.SECONDS));
                pipeline.addLast(new HeartBeatHandler());
		
		//添加对象解码器 负责对序列化POJO对象进行解码 设置对象序列化最大长度为1M 防止内存溢出
		//设置线程安全的WeakReferenceMap对类加载器进行缓存 支持多线程并发访问  防止内存溢出 
//		pipeline.addLast(new ObjectDecoder(1024*1024,ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
		//添加对象编码器 在服务器对外发送消息的时候自动将实现序列化的POJO对象编码
//		pipeline.addLast(new ObjectEncoder());
		
//                pipeline.addLast(new TcpServerHandler1());
		pipeline.addLast(tcpServerHandler2);
		
	}

	
}
