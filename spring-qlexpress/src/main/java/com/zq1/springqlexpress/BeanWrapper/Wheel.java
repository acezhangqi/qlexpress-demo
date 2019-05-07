package com.zq1.springqlexpress.BeanWrapper;

/**
 * @author zhangqi
 * @date 2019/2/19 上午9:31
 */

public class Wheel {
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Wheel{" +
            "position='" + position + '\'' +
            '}';
    }
}
