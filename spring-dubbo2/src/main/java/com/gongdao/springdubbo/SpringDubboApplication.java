package com.gongdao.springdubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:dubbo.xml"})
public class SpringDubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDubboApplication.class, args);
    }

}
