package macro;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import org.junit.Test;

/**
 * @author zhangqi
 * @date 2019/1/28 下午4:41
 */

public class MacroTest {

    @Test
    public void addMacro() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        runner.addMacro("计算平均成绩", "(语文+数学+英语)/3.0");
        runner.addMacro("是否优秀", "计算平均成绩>90");
        IExpressContext<String, Object> context =new DefaultContext<String, Object>();
        context.put("语文", 88);
        context.put("数学", 99);
        context.put("英语", 95);
        Object result = runner.execute("是否优秀", context, null, false, false);
        System.out.println(result);
        //返回结果true
    }
}
