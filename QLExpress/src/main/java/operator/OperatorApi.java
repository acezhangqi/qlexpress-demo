package operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.Operator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhangqi
 * @date 2019/1/28 上午11:12
 */

public class OperatorApi {

    @Test
    public void addOperatorDemo() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String,Object> context = new DefaultContext<String, Object>();
        runner.addOperator("累加", new Operator() {
            @Override
            public Integer executeInner(Object[] objects) throws Exception {
                Integer result = 0;
                for (int i =0;i < objects.length;i++){
                    Integer j = Integer.parseInt(String.valueOf(objects[i]));
                    result = result + j;
                }
                return result;
            }
        });
        context.put("a",1);
        context.put("b",2);
        Integer r = (Integer)runner.execute("a 累加 b", context, null, false, false);
        System.out.println(r);

    }


    @Test
    public void replaceOperatorDemo() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String,Object> context = new DefaultContext<String, Object>();
        runner.replaceOperator("<", new Operator() {
            @Override
            public Object executeInner(Object[] objects) throws Exception {
                Integer i = Integer.parseInt(String.valueOf(objects[0]));
                Integer j = Integer.parseInt(String.valueOf(objects[1]));
                return i == j;
            }
        });
        context.put("a",1);
        context.put("b",1);
        boolean r = (boolean)runner.execute("a < b", context, null, false, false);
        System.out.println(r);
    }


    @Test
    public void addOperatorWithAlias() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        //定义操作符addN，其实现为AddNOperator，语法格式与in一致
        runner.addOperatorWithAlias("如果", "if",null);
        runner.addOperatorWithAlias("则", "then",null);
        runner.addOperatorWithAlias("否则", "else",null);
        //执行表达式，并将结果赋给r
        String exp = "如果  (语文+数学+英语>270) 则 {return 1;} 否则 {return 0;}";
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        Integer i = (Integer)runner.execute(exp,context,null,false,false,null);
        System.out.println(i);
    }


    @Test
    public void addOperator2() throws Exception {
        //定义表达式，相当于4+1+2+3
        String exp = "4 addN (1,2,3)";
        ExpressRunner runner = new ExpressRunner();
        //定义操作符addN，其实现为AddNOperator，语法格式与in一致
        runner.addOperator("addN", "in", new Operator() {
            @Override
            public Object executeInner(Object[] list) throws Exception {
                int r = 0;
                for(int i=0;i<list.length;i++){
                    r = r + (Integer)list[i];
                }
                return r;
            }
        });
        //执行表达式，并将结果赋给r
        int r = (Integer)runner.execute(exp,null,null,false,false);
        System.out.println(r);
    }



}
