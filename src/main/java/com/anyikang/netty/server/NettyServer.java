
package com.anyikang.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.anyikang.config.NettyConfig;
import com.anyikang.netty.ServiceExporter;


/**
 * Main Server
 * @author wangwei
 * @date 2017年3月1日
 */
@Component
public class NettyServer {

	@Autowired
	private NettyConfig nettyConfig;
	
	@Autowired
    @Qualifier("somethingServerHandler")
    private ChannelInboundHandlerAdapter somethingServerHandler;
	
	 private static final StringDecoder DECODER = new StringDecoder();
	 private static final StringEncoder ENCODER = new StringEncoder();
	
    private InetSocketAddress tcpSocketAddress;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Channel channel;

    private Map<String, Object> exportServiceMap = new HashMap<String, Object>();
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);  

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
                .option(ChannelOption.SO_KEEPALIVE, nettyConfig.isKeepAlive())
                .option(ChannelOption.SO_BACKLOG, nettyConfig.getBacklog())
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                        		.addLast(new DelimiterBasedFrameDecoder(1024*1024, Delimiters.lineDelimiter()))
                                .addLast(DECODER)
                                .addLast(ENCODER)
                                .addLast(somethingServerHandler);//注册的业务逻辑
                    }
                });
                /*.childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast("decoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4))
                                .addLast("encoder", new LengthFieldPrepender(4, false))
                                .addLast(new RpcDecoder(RpcRequest.class))
                                .addLast(new RpcEncoder(RpcResponse.class))
                                .addLast(new ServerRpcHandler(exportServiceMap));
                    }
                });*/
                
                
        
        channel =  serverBootstrap.bind(tcpSocketAddress).sync().channel().closeFuture().sync().channel();
    
//        channel = serverBootstrap.bind(tcpSocketAddress).sync().channel();
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

    
    /**
     * 利用此方法获取spring ioc接管的所有bean
     * @param ctx
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        Map<String, Object> serviceMap = ctx.getBeansWithAnnotation(ServiceExporter.class); // 获取所有带有 ServiceExporter 注解的 Spring Bean
        logger.info("获取到所有的RPC服务:{}", serviceMap);
        if (serviceMap != null && serviceMap.size() > 0) {
            for (Object serviceBean : serviceMap.values()) {
                String interfaceName = serviceBean.getClass().getAnnotation(ServiceExporter.class)
                        .targetInterface()
                        .getName();
                logger.info("register service mapping:{}",interfaceName);
                exportServiceMap.put(interfaceName, serviceBean);
            }
        }
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
