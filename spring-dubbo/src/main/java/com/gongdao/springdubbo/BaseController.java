package com.gongdao.springdubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.ProxyFactory;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangqi
 * @date 2019/2/20 下午1:19
 */
@RestController
public class BaseController {


    @RequestMapping("/duubo")
    public String dubbotest(){
        ProxyFactory proxyFactory = (ProxyFactory)ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();
        return "ok";
    }

    @Test
    public void test(){
        ProxyFactory proxyFactory = (ProxyFactory)ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();
    }

    @Test
    public void test11(){
        Protocol protocol = (Protocol)ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();

    }
}
