package com.gongdao.springqlexpress.BeanWrapper;

import java.util.Arrays;

/**
 * @author zhangqi
 * @date 2019/2/19 上午9:31
 */

public class Car {

    private  String name;

    private Wheel[] wheels;
    private Driver driver;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", wheels=" + Arrays.toString(wheels) +
            ", driver=" + driver +
            '}';
    }
}
