package spi.demo;

import java.util.ServiceLoader;

/**
 * @author zhangqi
 * @date 2019/2/13 下午7:50
 */

public class Client {

    public static void main(String[] args) throws ClassNotFoundException {
       Class clazz = Class.forName("spi.demo.CommandA");
        System.out.println(clazz.isAnnotationPresent(First.class));
    }
}
