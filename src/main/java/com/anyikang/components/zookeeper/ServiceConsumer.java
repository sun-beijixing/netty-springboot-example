package com.anyikang.components.zookeeper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务消费者
 * @author wangwei
 * @date 2017年3月22日
 */
public class ServiceConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceConsumer.class);
	
	private final String ZK_CONNECTION_STRING = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
	private final int ZK_SESSION_TIMEOUT = 5000;

	// 用于等待 SyncConnected 事件触发后继续执行当前线程
	private CountDownLatch latch = new CountDownLatch(1);

	// 定义一个 volatile 成员变量，用于保存最新的 RMI 地址（考虑到该变量或许会被其它线程所修改，一旦修改后，该变量的值会影响到所有线程）
	private volatile List<String> urlList = new ArrayList<String>();

	// 构造器
	public ServiceConsumer(RegistryPath registryPath) {
		ZooKeeper zk = connectServer(); // 连接 ZooKeeper 服务器并获取 ZooKeeper 对象
		if (zk != null) {
			watchNode(zk,registryPath); // 观察 /registry 节点的所有子节点并更新 urlList 成员变量
		}
		
		List<String> list=new ArrayList<String>();
	}

	// 查找 RMI 服务
	public <T extends Remote> T lookup() {
		T service = null;
		int size = urlList.size();
		if (size > 0) {
			String url;
			if (size == 1) {
				url = urlList.get(0); // 若 urlList 中只有一个元素，则直接获取该元素
				LOGGER.debug("using only url: {}", url);
			} else {
				url = urlList.get(ThreadLocalRandom.current().nextInt(size)); // 若urlList中存在多个元素，则随机获取一个元素
				LOGGER.debug("using random url: {}", url);
			}
			service = lookupService(url); // 从 JNDI 中查找 RMI 服务
		}
		return service;
	}

	// 连接 ZooKeeper 服务器
	private ZooKeeper connectServer() {
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(ZK_CONNECTION_STRING, ZK_SESSION_TIMEOUT, new Watcher() {
				@Override
				public void process(WatchedEvent event) {
					if (event.getState() == Event.KeeperState.SyncConnected) {
						latch.countDown(); // 唤醒当前正在执行的线程
					}
				}
			});
			latch.await(); // 使当前线程处于等待状态
		} catch (IOException e) {
			LOGGER.error("", e);
		}catch ( InterruptedException e) {
			LOGGER.error("", e);
		}
		return zk;
	}

	// 观察 /registry 节点下所有子节点是否有变化
	private void watchNode(final ZooKeeper zk,final RegistryPath registryPath) {
		try {
			List<String> nodeList = zk.getChildren(registryPath.getRootPath(), new Watcher() {
				@Override
				public void process(WatchedEvent event) {
					if (event.getType() == Event.EventType.NodeChildrenChanged) {
						watchNode(zk,registryPath); // 若子节点有变化，则重新调用该方法（为了获取最新子节点中的数据）
					}
				}
			});
			List<String> dataList = new ArrayList<String>(); // 用于存放 /registry所有子节点中的数据
			for (String node : nodeList) {
				byte[] data = zk.getData(registryPath.getRootPath() + "/" + node, false, null); // 获取registry的子节点中的数据
				dataList.add(new String(data));
			}
			LOGGER.debug("node data: {}", dataList);
			urlList = dataList; // 更新最新的 RMI 地址
		} catch (KeeperException e) {
			LOGGER.error("", e);
		}catch (InterruptedException e) {
			LOGGER.error("", e);
		}
	}

	// 在 JNDI 中查找 RMI 远程服务对象
	@SuppressWarnings("unchecked")
	private <T> T lookupService(String url) {
		T remote = null;
		try {
			remote = (T) Naming.lookup(url);
		} catch (NotBoundException e) {
			LOGGER.error("", e);
		}catch ( MalformedURLException e) {
			LOGGER.error("", e);
		}catch ( RemoteException e) {
			if (e instanceof ConnectException) {
				// 若连接中断，则使用 urlList 中第一个 RMI 地址来查找（这是一种简单的重试方式，确保不会抛出异常）
				LOGGER.error("ConnectException -> url: {}", url);
				if (urlList.size() != 0) {
					url = urlList.get(0);
					return lookupService(url);
				}
			}
			LOGGER.error("", e);
		}
		return remote;
	}
}
