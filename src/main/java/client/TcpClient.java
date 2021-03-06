///**
// * 
// */
//package client;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.Channel;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.string.StringDecoder;
//import io.netty.handler.codec.string.StringEncoder;
//import io.netty.util.CharsetUtil;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//  
///**
// * @author wangwei
// * @date 2017年3月2日
// */
//public class TcpClient {  
//    private static final Logger logger = LoggerFactory.getLogger(TcpClient.class); 
//    public static String HOST = "127.0.0.1";  
//    public static int PORT = 8090;  
//      
//    public static Bootstrap bootstrap = getBootstrap();  
//    public static Channel channel = getChannel(HOST,PORT);  
//    
//	
//    /** 
//     * 初始化Bootstrap 
//     * @return 
//     */  
//    public static final Bootstrap getBootstrap(){  
//        EventLoopGroup group = new NioEventLoopGroup();  
//        Bootstrap b = new Bootstrap();  
//        b.group(group).channel(NioSocketChannel.class);  
//        b.handler(new ChannelInitializer<Channel>() {  
//            @Override  
//            protected void initChannel(Channel ch) throws Exception {  
//                ChannelPipeline pipeline = ch.pipeline();  
//                //添加字符串编码解码器
//                pipeline.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));  
//                pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8)); 
//                //添加POJO对象解码器 禁止缓存类加载器
////                pipeline.addLast(new ObjectDecoder(1024,ClassResolvers.cacheDisabled(this.getClass().getClassLoader())));
//                //设置发送消息编码器
////                pipeline.addLast(new ObjectEncoder());
//                //设置网络IO处理器
//                pipeline.addLast("handler", new TcpClientHandler());  
//            }  
//        });  
//        b.option(ChannelOption.SO_KEEPALIVE, true);  
//        return b;  
//    }  
//  
//    public static final Channel getChannel(String host,int port){  
//        Channel channel = null;  
//        try {  
//            channel = bootstrap.connect(host, port).sync().channel();  
//        } catch (Exception e) {  
//            logger.error(String.format("连接Server(IP[%s],PORT[%s])失败", host,port),e);  
//            return null;  
//        }  
//        return channel;  
//    }  
//  
//    public static void sendMsg(String msg) throws Exception {  
//        if(channel!=null){  
//            channel.writeAndFlush(msg).sync();  
//        }else{  
//            logger.warn("消息发送失败,连接尚未建立!");  
//        }  
//    }  
//    
//    public static void sendObject(Object obj) throws Exception {  
//    	if(channel!=null){  
//    		channel.writeAndFlush(obj).sync();  
//    	}else{  
//    		logger.warn("消息发送失败,连接尚未建立!");  
//    	}  
//    }  
//    
//  
//    public static void main(String[] args) throws Exception {  
//        try {  
//            long t0 = System.nanoTime();  
//            for (int i = 0; i < 10; i++) {  
//            	TcpClient.sendMsg(i+"你好1");  
//            	
////            	ObjectRequest req=new ObjectRequest();
////            	req.setId(i);
////            	req.setName("张三"+i);
////            	req.setAge(15+i);
////            	TcpClient.sendObject(req);
//            }  
//            long t1 = System.nanoTime();  
//            System.out.println((t1-t0)/1000000.0);  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//    }  
//}  
