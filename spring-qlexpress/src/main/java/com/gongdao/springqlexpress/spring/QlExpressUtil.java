package com.gongdao.springqlexpress.spring;

import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import com.ql.util.express.Operator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * （1）打通了spring容器，通过扩展IExpressContext->QLExpressContext
 * 获取本地变量的时候，可以获取到spring的bean
 * （2）在runner初始化的时候，使用了函数映射功能：addFunctionOfServiceMethod
 * （3）在runner初始化的时候，使用了代码映射功能：addMacro
 */
@Component
public class QlExpressUtil implements ApplicationContextAware {

	private static ExpressRunner runner;
	static {
		runner = new ExpressRunner();
	}
	private static boolean isInitialRunner = false;
	private ApplicationContext applicationContext;

	/**
	 * 
	 * @param statement
	 *            执行语句
	 * @param context
	 *            上下文
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Object execute(String statement, Map<String, Object> context)
			throws Exception {
		initRunner(runner);
		IExpressContext expressContext = new QLExpressContext(context,
				applicationContext);
		return runner.execute(statement, expressContext, null, true, false);
	}


	public String[] getOutVar(String express) throws Exception {
        String[] names = runner.getOutVarNames(express);
        return names;
    }

    public String[] getFunction(String express) throws Exception {
	   return  runner.getOutFunctionNames(express);
    }


	private void initRunner(ExpressRunner runner) {
		if (isInitialRunner == true) {
			return;
		}
		synchronized (runner) {
			if (isInitialRunner == true) {
				return;
			}
			try {
				runner.addMacro("judgeLoginer","   if (\"peopelMediation\".equals(mediationType)){\n"
                    + "              return true;\n"
                    + "          }else {\n"
                    + "              return false;\n"
                    + "          }");
				runner.addMacro("peopleMediation","  if (money < 1000){return 150;}else if ( money >= 1000 && money < 5000){\n"
                    + "            return 300;\n"
                    + "        }else if ( money >= 5000 && money <50000){\n"
                    + "            return 450;\n"
                    + "        }else if ( money >= 50000){\n"
                    + "            return 800;\n"
                    + "        }\n"
                    + "        return null;");

			} catch (Exception e) {
				throw new RuntimeException("初始化失败表达式", e);
			}
		}
		isInitialRunner = true;
	}

	public void setApplicationContext(ApplicationContext aContext)
			throws BeansException {
		applicationContext = aContext;
	}
   public ExpressRunner getRunner(){
		return runner;
   }
}
