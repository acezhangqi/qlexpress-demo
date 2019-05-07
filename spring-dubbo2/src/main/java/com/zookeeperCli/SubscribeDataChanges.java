package com.zookeeperCli;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * 订阅节点的数据内容的变化
 */
public class SubscribeDataChanges {
	private static class ZKDataListener implements IZkDataListener {

		public void handleDataChange(String dataPath, Object data)
				throws Exception {
			System.out.println("订阅节点的数据内容的变化"+dataPath + ":" + data.toString());
		}

		public void handleDataDeleted(String dataPath) throws Exception {
			System.out.println("订阅节点的数据内容被删除"+dataPath);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ZkClient zkClient = CreateSession.connectZK();

		zkClient.subscribeDataChanges("/aganNode", new ZKDataListener());
		Thread.sleep(Integer.MAX_VALUE);

	}
}
