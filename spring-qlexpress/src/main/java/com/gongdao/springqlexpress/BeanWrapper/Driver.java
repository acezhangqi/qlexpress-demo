package com.gongdao.springqlexpress.BeanWrapper;

/**
 * @author zhangqi
 * @date 2019/2/19 上午9:32
 */

public class Driver {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Driver{" +
            "age=" + age +
            '}';
    }
}
