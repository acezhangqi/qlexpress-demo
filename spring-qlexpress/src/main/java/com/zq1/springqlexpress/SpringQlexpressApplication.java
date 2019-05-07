package com.zq1.springqlexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringQlexpressApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringQlexpressApplication.class,args);
        String username = context.getEnvironment().getProperty("jdbc.root.user");
        String password = context.getEnvironment().getProperty("jdbc.root.password");
        System.out.println("username==="+username);
        System.out.println("password==="+password);
        context.close();

    }

}

