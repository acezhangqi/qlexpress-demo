package com.gongdao.springdubbo;

import org.springframework.stereotype.Service;
import spi.Hello;

/**
 * @author zhangqi
 * @date 2019/2/20 下午1:32
 */
@Service
public class HelloImpl implements Hello {
    @Override
    public String sayHello(String s) {
        return "dubbo启动成功";
    }
}
