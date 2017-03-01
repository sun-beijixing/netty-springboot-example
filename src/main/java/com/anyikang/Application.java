
package com.anyikang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.anyikang.netty.TCPServer;

/**
 * Spring Java Configuration and Bootstrap
 *
 * @author wangwei                 
 */
@SpringBootApplication
@PropertySource(value= "classpath:/properties/local/nettyserver.properties")
public class Application {

    @Configuration
    @Profile("production")
    @PropertySource("classpath:/properties/production/nettyserver.properties")
    static class Production
    { }

    @Configuration
    @Profile("local")
    @PropertySource({"classpath:/properties/local/nettyserver.properties"})
    static class Local
    { }

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        TCPServer tcpServer = context.getBean(TCPServer.class);
        tcpServer.start();

    }


}