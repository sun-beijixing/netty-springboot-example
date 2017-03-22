/*package com.anyikang.remote.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.anyikang.remote.server.impl.HelloServiceImpl;

public class RmiServer {
	public static void main(String[] args) throws Exception {
        int port = 1099;
        String url = "rmi://localhost:1099/com.anyikang.remote.server.impl.HelloServiceImpl";
        // JNDI 中创建注册表
        LocateRegistry.createRegistry(port);
        
        // unbind() 与 bind() 
        Naming.rebind(url, new HelloServiceImpl());
        System.out.println("服务器向命名表注册了个远程服务对象");
    }
}
*/