package com.anyikang.components.zookeeper;

public interface Constant {
//	String ZK_CONNECTION_STRING = "127.0.0.1:2181";
//	String ZK_CONNECTION_STRING = "127.0.0.1:2181,127.0.0.1:2182";
	String ZK_CONNECTION_STRING = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
	int ZK_SESSION_TIMEOUT = 5000;
	String ZK_REGISTRY_PATH = "/registry";
	String ZK_PROVIDER_PATH = ZK_REGISTRY_PATH + "/provider";
}
