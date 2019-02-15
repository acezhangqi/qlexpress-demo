package com.gongdao.springqlexpress.spring;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangqi
 * @date 2019/1/30 下午3:44
 */

public class MyTest {

    QlExpressUtil qlExpressUtil = new QlExpressUtil();

    //@Test
    //public void test1(String exp,Object object) throws Exception {
    //    //具体表达式写在配置文件中。
    //    String express = "if(judgeLoginer(mediationType)){peopleMediation(meoney);}else {otherMediation(money); money2}";
    //    qlExpressUtil.getRunner().addMacro("otherMediation","  if (money <= 10000){\n"
    //        + "            return 400;\n"
    //        + "        }else if ( money > 10000 && money <= 50000){\n"
    //        + "            return 600;\n"
    //        + "        }else if ( money > 50000 && money <= 100000){\n"
    //        + "            return 800;\n"
    //        + "        }else if ( money > 100000){\n"
    //        + "            return 1000;\n"
    //        + "        }\n"
    //        + "        return null;");
    //    TestBean testBean = new TestBean();
    //    testBean.setName("zhangsan");
    //    testBean.setAge("12");
    //    JSONObject jsonObject = new JSONObject();
    //    jsonObject.put("fast","A");
    //    jsonObject.put("fast2","B");
    //    Map<String, Object> context = new HashMap<String, Object>();
    //    context = jsonObject;
    //    System.out.println(context);
    //    Integer i = (Integer)qlExpressUtil.execute(express,context);
    //    System.out.println(Arrays.toString(qlExpressUtil.getFunction(express)));
    //    System.out.println(Arrays.toString(qlExpressUtil.getOutVar(express)));
    //    System.out.println(i);
    //}

    public static void main(String[] args) throws Exception {
        //具体表达式写在配置文件中
        QlExpressUtil qlExpressUtil = new QlExpressUtil();
        String express = "if(judgeLoginer(mediationType)){peopleMediation(money);}else {otherMediation(money); moeny2}";

        qlExpressUtil.getRunner().addMacro("otherMediation","  if (money <= 10000){\n"
            + "            return 400;\n"
            + "        }else if ( money > 10000 && money <= 5001){\n"
            + "            return 600;\n"
            + "        }else if ( money > 50000 && money <= 100000){\n"
            + "            return 800;\n"
            + "        }else if ( money > 100000){\n"
            + "            return 1000;\n"
            + "        }\n"
            + "        return null;");
        Map<String, Object> context = new HashMap<String, Object>();
        context.put("money",10001);
        context.put("mediationType","otherMediation");
        Integer i = (Integer)qlExpressUtil.execute(express,context);
        System.out.println(i);
    }

    @Test
    public void test1(){
        TestBean testBean = new TestBean();
        testBean.setName("zhangsandsad");
        testBean.setAge("12");
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("newName", testBean);
        Expression exp = parser.parseExpression("#newName.getName()");
        String phraseStr = (String)exp.getValue(context);
        System.out.println(phraseStr);
    }

}
