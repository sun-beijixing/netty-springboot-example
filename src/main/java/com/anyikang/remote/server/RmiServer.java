package com.anyikang.remote.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.anyikang.remote.server.impl.HelloServiceImpl;
import com.anyikang.remote.server.service.HelloService;

public class RmiServer {
	public static void main(String[] args) throws Exception {
        int port = 1099;
        String url = "rmi://localhost:1099/demo.zookeeper.rmi.server.HelloServiceImpl";
        // JNDI 中创建注册表
        LocateRegistry.createRegistry(port);
        
        HelloService service02 = new HelloServiceImpl(); 
        
        // unbind() 与 bind() 
        Naming.rebind(url, service02);
        System.out.println("服务器向命名表注册了个远程服务对象");
    }
}
