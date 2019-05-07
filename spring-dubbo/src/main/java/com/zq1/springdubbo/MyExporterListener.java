package com.zq1.springdubbo;

import com.alibaba.dubbo.rpc.*;

/**
 * @author zhangqi
 * @date 2019/2/22 下午6:52
 */

public class MyExporterListener implements ExporterListener,InvokerListener {
    @Override
    public void exported(Exporter<?> exporter) throws RpcException {
        System.out.println("暴露" + exporter.getInvoker().getInterface());
    }

    @Override
    public void unexported(Exporter<?> exporter) {

    }

    @Override
    public void referred(Invoker<?> invoker) throws RpcException {
        System.out.println("被引用");
    }

    @Override
    public void destroyed(Invoker<?> invoker) {

    }
}
