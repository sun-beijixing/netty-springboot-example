/*package com.anyikang.remote.client;

import java.rmi.Naming;

import com.anyikang.remote.server.service.HelloService;


public class RmiClient {
	public static void main(String[] args) throws Exception {
        String url = "rmi://localhost:1099/com.anyikang.remote.server.impl.HelloServiceImpl";
        HelloService helloService = (HelloService) Naming.lookup(url);
        String result = helloService.sayHello("Jack");
        System.out.println(result);
    }
}
*/