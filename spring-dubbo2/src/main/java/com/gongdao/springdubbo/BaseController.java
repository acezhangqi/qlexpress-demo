package com.gongdao.springdubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.registry.RegistryFactory;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.ProxyFactory;
import com.alibaba.dubbo.rpc.cluster.Cluster;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.rmi.registry.Registry;

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

    @Test
    public void test1331(){
        RegistryFactory registryFactory = (RegistryFactory)ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();

    }

    @Test
    public void test132331(){
        RegistryFactory extension = (RegistryFactory)ExtensionLoader.getExtensionLoader(RegistryFactory.class).getExtension("zookeeper");
        System.out.println(extension);
    }

    @Test
    public void test1111(){
        Cluster cluster = (Cluster)ExtensionLoader.getExtensionLoader(Cluster.class).getAdaptiveExtension();
        System.out.println(cluster);
    }


    @Test
    public void test123(){
        BigDecimal n = new BigDecimal("3.223423423").subtract(new BigDecimal("3.223423424"));
        System.out.println(n);
    }

}
