package com.gongdao.springqlexpress.spring;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangqi
 * @date 2019/1/30 下午3:44
 */

public class MyTest {

    QlExpressUtil qlExpressUtil = new QlExpressUtil();
    @Test
    public void test1() throws Exception {
        //具体表达式写在配置文件中。
        String express = "if(judgeLoginer(mediationType)){peopleMediation(meoney);}else {otherMediation(money);}";
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("money", 8000);
        context.put("mediationType","peopelMediation");
        Integer i = (Integer)qlExpressUtil.execute(express,context);
        System.out.println(i);
    }
}
