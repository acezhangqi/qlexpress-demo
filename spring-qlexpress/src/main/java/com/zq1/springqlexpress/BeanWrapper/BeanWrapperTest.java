package com.zq1.springqlexpress.BeanWrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;



/**
 * @author zhangqi
 * @date 2019/2/19 上午9:32
 */

public class BeanWrapperTest {
    public static void main(String[] args) {
        //左边轮子的BeanWrapper
        Wheel leftWheel = new Wheel();
        BeanWrapper beanWrapperOfLeftWheel = PropertyAccessorFactory.forBeanPropertyAccess(leftWheel);
        PropertyValue leftPosition = new PropertyValue("position", "左边");
        beanWrapperOfLeftWheel.setPropertyValue(leftPosition);
        System.out.println(beanWrapperOfLeftWheel.getWrappedInstance());

        //左边轮子的BeanWrapper
        Wheel rightWheel = new Wheel();
        BeanWrapper beanWrapperOfRightWheel = PropertyAccessorFactory.forBeanPropertyAccess(rightWheel);
        PropertyValue rightPosition = new PropertyValue("position", "右边");
        beanWrapperOfRightWheel.setPropertyValue(rightPosition);
        System.out.println(beanWrapperOfRightWheel.getWrappedInstance());

        // 驾驶员
        Driver driver = new Driver();
        BeanWrapper beanWrapperOfDriver = PropertyAccessorFactory.forBeanPropertyAccess(driver);
        PropertyValue age = new PropertyValue("age", 20);
        beanWrapperOfDriver.setPropertyValue(age);
        System.out.println(beanWrapperOfDriver.getWrappedInstance());


        // 车子
        Car car = new Car();
        BeanWrapper beanWrapperOfCar = PropertyAccessorFactory.forBeanPropertyAccess(car);
        beanWrapperOfCar.setPropertyValue("name", "奔驰"); // 车名
        Wheel[] wheels = {leftWheel, rightWheel}; //轮子数组
        beanWrapperOfCar.setPropertyValue("wheels", wheels); //轮子
        beanWrapperOfCar.setPropertyValue("driver", driver); //驾驶员
        System.out.println(beanWrapperOfCar.getWrappedInstance());

        // 获取驾驶员的年龄
        int retrievedAge = (Integer) beanWrapperOfCar.getPropertyValue("driver.age");
        System.out.println("driver age : " + retrievedAge);


        // 通过表达式间接设置car的wheel的width
        beanWrapperOfCar.setPropertyValue("wheels[0].position", "修改过的左边");
        System.out.println(beanWrapperOfCar.getWrappedInstance());
    }

}
