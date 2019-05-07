package com.snapshot;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author zhangqi
 * @date 2019/3/18 下午1:51
 */

public class ProtoBufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
       DataInfo.Person person  = DataInfo.Person.newBuilder().setName("张三").setAddress("北京").setAge(1).build();
       byte[] bytes = person.toByteArray();
       DataInfo.Person person1 =DataInfo.Person.parseFrom(bytes);
        System.out.println(person1.getAddress()+"|"+person1.getName()+","+person1.getAge());
    }
}
