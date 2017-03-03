
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

    private Map<String, Object> exportServiceMap = new HashMap<String, Object>();

    /**
     * 启动服务
     * @throws Exception
     */
    @PostConstruct
    public void start() throws Exception {
        logger.info("begin to start rpc server");
        
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        bossGroup=new NioEventLoopGroup(nettyConfig.getBossCount());
        workerGroup=new NioEventLoopGroup(nettyConfig.getWorkerCount());
        tcpSocketAddress=new InetSocketAddress(nettyConfig.getTcpHost(),nettyConfig.getTcpPort());
        
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
                        pipeline.addLast(DECODER);
                        pipeline.addLast(ENCODER);
//                        pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));  
//                        pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));  
                        
//                        pipeline.addLast(new TcpServerHandler1());
                        pipeline.addLast(new TcpServerHandler2());
                        
                        /*pipeline
                        .addLast(new RpcDecoder(RpcRequest.class))
                        .addLast(new RpcEncoder(RpcResponse.class))
                        .addLast(new ServerRpcHandler(exportServiceMap));*/
                        
                        /*ChannelPipeline pipeline = ch.pipeline();  
                        pipeline.addLast(new TcpServerHandler());  */
                    }
                });
                
        channel = serverBootstrap.bind(tcpSocketAddress).sync().channel();
        logger.info("NettyRPC server listening on port " + tcpSocketAddress.getPort() + " and ready for connections...");
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

    
    
    
    
    
    
    
    /*public ServerBootstrap getServerBootstrap() {
        return serverBootstrap;
    }

    public void setServerBootstrap(ServerBootstrap serverBootstrap) {
        this.serverBootstrap = serverBootstrap;
    }

    public InetSocketAddress getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(InetSocketAddress tcpPort) {
        this.tcpPort = tcpPort;
    }*/
}
