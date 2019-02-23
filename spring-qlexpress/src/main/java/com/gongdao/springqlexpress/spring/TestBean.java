package com.gongdao.springqlexpress.spring;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangqi
 * @date 2019/1/31 上午9:15
 */

public class TestBean {

    private String name;
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Test
    public void test(){
        List<String> fields = Arrays.asList("a","b","c");
        System.out.println(fields);
    }
}
