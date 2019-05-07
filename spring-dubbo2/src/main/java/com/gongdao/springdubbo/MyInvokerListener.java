package com.gongdao.springdubbo;

import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.InvokerListener;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * @author zhangqi
 * @date 2019/2/22 下午7:01
 */

public class MyInvokerListener implements InvokerListener {
    @Override
    public void referred(Invoker<?> invoker) throws RpcException {
        System.out.println(invoker.getInterface() + "被引用");
    }

    @Override
    public void destroyed(Invoker<?> invoker) {

    }
}
