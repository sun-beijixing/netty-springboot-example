
package com.anyikang.components.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anyikang.config.NettyConfig;


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
	
    private InetSocketAddress tcpSocketAddress;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Channel channel;
    
    
    /**
     * 配置NIO线程组
	 * @param nettyConfig
	 */
    @Autowired
	public NettyServer(NettyConfig nettyConfig) {
		super();
		this.nettyConfig = nettyConfig;
		bossGroup=new NioEventLoopGroup(nettyConfig.getBossCount());
		workerGroup=new NioEventLoopGroup(nettyConfig.getWorkerCount());
		tcpSocketAddress=new InetSocketAddress(nettyConfig.getTcpHost(),nettyConfig.getTcpPort());
	}

	/**
     * 启动服务
     * @throws Exception
     */
    @PostConstruct
    public void start() throws Exception {
        logger.info("================开始启动服务=================");
    	//服务器辅助启动类配置
    	ServerBootstrap serverBootstrap = new ServerBootstrap();
    	serverBootstrap.group(bossGroup, workerGroup)
    	.channel(NioServerSocketChannel.class)
    	.handler(new LoggingHandler(LogLevel.DEBUG))
    	.childHandler(new NettyServerChannelInitializer())
    	.option(ChannelOption.SO_BACKLOG, nettyConfig.getBacklog())
    	.childOption(ChannelOption.SO_KEEPALIVE, nettyConfig.isKeepalive())
    	.childOption(ChannelOption.TCP_NODELAY, true);
    	
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
        
        if (channel != null) {
        	channel.close();
		}
		if (workerGroup != null) {
			workerGroup.shutdownGracefully();
		}
		if (bossGroup != null) {
			bossGroup.shutdownGracefully();
		}
		if (tcpSocketAddress != null) {
			tcpSocketAddress=null;
		}
    }
    
    
}
