
package com.anyikang.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.config.NettyConfig;
import com.anyikang.netty.handler.TcpServerHandler2;


/**
 * Main Server
 * @author wangwei
 * @date 2017年3月1日
 */
@Component
public class NettyServer {
	
	private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);  

	@Autowired
	private NettyConfig nettyConfig;
	
	private static final StringDecoder DECODER = new StringDecoder(CharsetUtil.UTF_8);
	private static final StringEncoder ENCODER = new StringEncoder(CharsetUtil.UTF_8);

    private InetSocketAddress tcpSocketAddress;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Channel channel;


    /**
     * 启动服务
     * @throws Exception
     */
    @PostConstruct
    public void start() throws Exception {
        logger.info("================开始启动服务=================");
        //配置NIO线程组
        bossGroup=new NioEventLoopGroup(nettyConfig.getBossCount());
        workerGroup=new NioEventLoopGroup(nettyConfig.getWorkerCount());
        
        tcpSocketAddress=new InetSocketAddress(nettyConfig.getTcpHost(),nettyConfig.getTcpPort());
        
    	//服务器辅助启动类配置
    	ServerBootstrap serverBootstrap = new ServerBootstrap();
    	serverBootstrap.group(bossGroup, workerGroup)
    	.channel(NioServerSocketChannel.class)
    	.childOption(ChannelOption.SO_KEEPALIVE, true)
    	.childOption(ChannelOption.TCP_NODELAY, true)
    	.handler(new LoggingHandler(LogLevel.DEBUG))
    	.option(ChannelOption.SO_KEEPALIVE, nettyConfig.isKeepalive())
    	.option(ChannelOption.SO_BACKLOG, nettyConfig.getBacklog())
    	.childHandler(new ChannelInitializer<SocketChannel>() {
    		@Override
    		protected void initChannel(SocketChannel socketChannel) throws Exception {
    			ChannelPipeline pipeline=socketChannel.pipeline();
    			//添加字符串编码解码器
//                        pipeline.addLast(DECODER);
//                        pipeline.addLast(ENCODER);
    			
    			//添加对象解码器 负责对序列化POJO对象进行解码 设置对象序列化最大长度为1M 防止内存溢出
    			//设置线程安全的WeakReferenceMap对类加载器进行缓存 支持多线程并发访问  防止内存溢出 
    			pipeline.addLast(new ObjectDecoder(1024*1024,ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
    			//添加对象编码器 在服务器对外发送消息的时候自动将实现序列化的POJO对象编码
    			pipeline.addLast(new ObjectEncoder());
    			
//                        pipeline.addLast(new TcpServerHandler1());
    			pipeline.addLast(new TcpServerHandler2());
    			
    		}
    	});
    	
    	channel = serverBootstrap.bind(tcpSocketAddress).sync().channel();
    	logger.info("Netty服务器监听连接成功的端口号是： " + tcpSocketAddress.getPort());
        	
    }
    
    /**
     * 结束服务
     * @throws Exception
     */
    @PreDestroy
    public void stop() {
        logger.info("destroy server resources");
        if (null == channel) {
            logger.error("server channel is null");
        }
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        channel.closeFuture().syncUninterruptibly();
        bossGroup = null;
        workerGroup = null;
        channel = null;
    }
    
    
}
