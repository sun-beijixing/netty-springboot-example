package com.anyikang.components.zookeeper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProvider.class);

	// 用于等待 SyncConnected 事件触发后继续执行当前线程
	private CountDownLatch latch = new CountDownLatch(1);

	// 发布 RMI 服务并注册 RMI 地址到 ZooKeeper 中
	public void publish(Remote remote, String host, int port) {
		String url = publishService(remote, host, port); // 发布 RMI 服务并返回 RMI 地址
		if (url != null) {
			ZooKeeper zk = connectServer(); // 连接 ZooKeeper 服务器并获取 ZooKeeper 对象
			if (zk != null) {
				createNode(zk, url); // 创建 ZNode 并将 RMI 地址放入 ZNode 上
			}
		}
	}

	// 发布 RMI 服务
	private String publishService(Remote remote, String host, int port) {
		String url = null;
		try {
			url = String.format("rmi://%s:%d/%s", host, port, remote.getClass().getName());
			LocateRegistry.createRegistry(port);
			Naming.rebind(url, remote);
			LOGGER.debug("publish rmi service (url: {})", url);
		} catch (RemoteException e) {
			LOGGER.error("", e);
		}catch (MalformedURLException e) {
			LOGGER.error("", e);
		}
		return url;
	}

	// 连接 ZooKeeper 服务器
	private ZooKeeper connectServer() {
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(Constant.ZK_CONNECTION_STRING, Constant.ZK_SESSION_TIMEOUT, new Watcher() {
				@Override
				public void process(WatchedEvent event) {
					if (event.getState() == Event.KeeperState.SyncConnected) {
						latch.countDown(); // 唤醒当前正在执行的线程
					}
				}
			});
			latch.await(); // 使当前线程处于等待状态
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zk;
	}

	// 创建 ZNode
	private void createNode(ZooKeeper zk, String url) {
		byte[] data = url.getBytes();
		try {
			zk.create(Constant.ZK_REGISTRY_PATH, data, Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
			String path = zk.create(Constant.ZK_PROVIDER_PATH, data, Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
			LOGGER.debug("create zookeeper node ({} => {})", path, url);
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 创建一个临时性且有序的 ZNode
	}
}
