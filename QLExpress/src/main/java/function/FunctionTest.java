package function;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import com.ql.util.express.Operator;
import org.junit.Test;

import java.util.List;

/**
 * @author zhangqi
 * @date 2019/1/28 上午9:46
 */

public class FunctionTest {


    @Test
    public void addFunction() throws Exception {
        BeanExample beanExample = new BeanExample();
        ExpressRunner runner = new ExpressRunner();
        runner.addFunction("abc", new Operator() {
            @Override
            public Object executeInner(Object[] list) throws Exception {
                Integer paramA = Integer.valueOf(list[0].toString())+1;
                Integer paramB = Integer.valueOf(list[1].toString())*3;
                Integer paramC = Integer.valueOf(list[2].toString());
                return  beanExample.plus(paramA,paramB,paramC);
            }
        });
        String exp = "abc(a,b,c)";
        IExpressContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a","1");
        context.put("b","2");
        context.put("c","3");
        System.out.println(runner.execute(exp, context, null, false, false));
    }

    @Test
    public void addFunctionOfServiceMedthod() throws Exception {
        BeanExample beanExample = new BeanExample();
        ExpressRunner runner = new ExpressRunner();
        runner.addFunctionOfServiceMethod("转换为大写", beanExample,
            "upper", new String[] { "String" }, null);
        String exp = "转换为大写(\"string\")";
        IExpressContext<String, Object> context = new DefaultContext<String, Object>();
        System.out.println(runner.execute(exp, context, null, false, false));
    }

    @Test
    public void addFunctionOfClassMethod() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        runner.addFunctionOfClassMethod("转换为大写", BeanExample.class.getName(),
            "upper", new String[] { "String" }, null);
        String exp = "转换为大写(\"hello world\")";
        DefaultContext<String,Object> context = new DefaultContext<>();
        String s   = (String)runner.execute(exp, context, null, false, false);
        System.out.println(s);
    }

    @Test
    public void  addFunctionAndClassMethod() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        runner.addFunctionAndClassMethod("是否大于0", String.class, new Operator() {
            @Override
            public Object executeInner(Object[] objects) throws Exception {
                Integer i = Integer.parseInt(String.valueOf(objects[0]));
                return i>0;
            }
        });
        String exp = "是否大于0(\"9\")";
        DefaultContext<String,Object> context = new DefaultContext<>();
        boolean s   = (boolean)runner.execute(exp, context, null, false, false);
        System.out.println(s);
    }

}
