package com.gongdao.springqlexpress.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author zhangqi
 * @date 2019/1/30 下午3:44
 */

public class MyTest {

    QlExpressUtil qlExpressUtil = new QlExpressUtil();
    //
    ////@Test
    ////public void test1(String exp,Object object) throws Exception {
    ////    //具体表达式写在配置文件中。
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
    ////    TestBean testBean = new TestBean();
    ////    testBean.setName("zhangsan");
    ////    testBean.setAge("12");
    ////    JSONObject jsonObject = new JSONObject();
    ////    jsonObject.put("fast","A");
    ////    jsonObject.put("fast2","B");
    ////    Map<String, Object> context = new HashMap<String, Object>();
    ////    context = jsonObject;
    ////    System.out.println(context);
    ////    Integer i = (Integer)qlExpressUtil.execute(express,context);
    ////    System.out.println(Arrays.toString(qlExpressUtil.getFunction(express)));
    ////    System.out.println(Arrays.toString(qlExpressUtil.getOutVar(express)));
    ////    System.out.println(i);
    ////}
    //
    ////public static void main(String{} args) throws Exception {
    ////    //具体表达式写在配置文件中
    ////    QlExpressUtil qlExpressUtil = new QlExpressUtil();
    ////    String express = "if(judgeLoginer(mediationType)){peopleMediation(money);}else {otherMediation(money); moeny2}";
    ////
    ////    qlExpressUtil.getRunner().addMacro("otherMediation","  if (money <= 10000){\n"
    ////        + "            return 400;\n"
    ////        + "        }else if ( money > 10000 && money <= 5001){\n"
    ////        + "            return 600;\n"
    ////        + "        }else if ( money > 50000 && money <= 100000){\n"
    ////        + "            return 800;\n"
    ////        + "        }else if ( money > 100000){\n"
    ////        + "            return 1000;\n"
    ////        + "        }\n"
    ////        + "        return null;");
    ////    Map<String, Object> context = new HashMap<String, Object>();
    ////    context.put("money",10001);
    ////    context.put("mediationType","otherMediation");
    ////    Integer i = (Integer)qlExpressUtil.execute(express,context);
    //    System.out.println(i);
    //}

    @Test
    public void test1(){
        TestBean testBean = new TestBean();
        testBean.setName("a");
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("newName", testBean);
        Expression exp = parser.parseExpression("#newName.getName()");
        String phraseStr = (String)exp.getValue();
        System.out.println(phraseStr);
    }

    @Test
    public void testJson(){
        String json = "{\n"
            + "    \"status\": \"success\",\n"
            + "    \"result\": [\n"
            + "        {\n"
            + "            \"caseCode\": 112134,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        },\n"
            + "        {\n"
            + "            \"caseCode\": 112135,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        },\n"
            + "        {\n"
            + "            \"caseCode\": 112136,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        },\n"
            + "        {\n"
            + "            \"caseCode\": 112137,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        },\n"
            + "        {\n"
            + "            \"caseCode\": 112138,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        },\n"
            + "        {\n"
            + "            \"caseCode\": 112139,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        },\n"
            + "        {\n"
            + "            \"caseCode\": 112140,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        },\n"
            + "        {\n"
            + "            \"caseCode\": 112141,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        },\n"
            + "        {\n"
            + "            \"caseCode\": 112142,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        },\n"
            + "        {\n"
            + "            \"caseCode\": 112143,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        }\n"
            + "    ],\n"
            + "    \"time\": 0.46288499999999977\n"
            + "}";
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("result");
        List<Map> maps  = JSON.parseArray(jsonArray.toJSONString(),Map.class);

    }


    @Test
    public void invokeAllTest() throws InterruptedException, ExecutionException {
      ExecutorService es = new ThreadPoolExecutor(4, 4,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });

        List<getTask> lists = new ArrayList<>();
        for (int i=0;i<10;i++){
           lists.add(new getTask(10001L));
        };
        List<Future<String>> futures = es.invokeAll(lists);
        for (Future<String> future:futures){
            System.out.println(future.get());
        }
    }
    private class getTask implements Callable<String> {

        private Long caseId;

        public getTask(Long caseId) {
            this.caseId = caseId;
        }

        @Override
        public String call() throws Exception {
            return "1";
        }
    }


}
