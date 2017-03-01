
package com.anyikang.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;

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


/**
 * Main Server
 * @author wangwei
 * @date 2017年3月1日
 */
@Component
public class NettyServer {

    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap serverBootstrap;

    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpSocketAddress;
    
    @Autowired
    @Qualifier("bossGroup")
    private EventLoopGroup bossGroup;
    
    @Autowired
    @Qualifier("workerGroup")
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
