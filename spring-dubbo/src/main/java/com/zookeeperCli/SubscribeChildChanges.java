package com.zookeeperCli;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 *订阅节点的信息改变（创建节点，删除节点，添加子节点）
 */
public class SubscribeChildChanges {
	private static class ZKChildListener implements IZkChildListener {
        /** 
         * handleChildChange： 用来处理服务器端发送过来的通知 
         * parentPath：对应的父节点的路径 
         * currentChilds：子节点的相对路径 
         */  
        public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {  
            System.out.println("订阅节点的信息改变（创建节点，删除节点，添加子节点）"+parentPath+"   "+currentChilds.toString());
        }  
          
    }  
      
    public static void main(String[] args) throws InterruptedException {  
    	ZkClient zkClient = CreateSession.connectZK();
        /** 
         * "/testUserNode" 监听的节点，可以是现在存在的也可以是不存在的 
         */  
        zkClient.subscribeChildChanges("/aganNode", new ZKChildListener());  
        Thread.sleep(Integer.MAX_VALUE);  
    }  
}
