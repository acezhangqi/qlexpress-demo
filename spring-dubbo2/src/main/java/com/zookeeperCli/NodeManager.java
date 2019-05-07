package com.zookeeperCli;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

public class NodeManager {

	public void createNode() {
		ZkClient zkClient = CreateSession.connectZK();
		User user = new User();
		user.setId(1);
		user.setName("agan1");

		/**
		 * "/testUserNode" :节点的地址 user：数据的对象 CreateMode.PERSISTENT：创建的节点类型
		 */
//		zkClient.createPersistent("/testUserNode", user);
		String path = zkClient.create("/aganNode", user,CreateMode.PERSISTENT);
		
		// 输出创建节点的路径
		System.out.println("创建节点:" + path);
	}

	public void updateNode() {
		ZkClient zkClient = CreateSession.connectZK();
		User user = new User();
		user.setId(2);
		user.setName("agan2");
		/**
		 * testUserNode 节点的路径 user 传入的数据对象
		 */
		zkClient.writeData("/aganNode", user);
		System.out.println("修改aganNode节点成功" );
	}
	
	public void deleteNode(){
		ZkClient zkClient = CreateSession.connectZK();
		//删除单独一个节点，返回true表示成功  
        boolean e1 = zkClient.delete("/aganNode");  
        //返回 true表示节点成功 ，false表示删除失败  
        System.out.println("删除aganNode节点是否成功："+e1);  
	}

	public static void main(String[] args) {
		NodeManager nm=new NodeManager();
		nm.createNode();
		nm.updateNode();
		//nm.deleteNode();
	}
}
