package dubbo.adaptive;

import com.alibaba.dubbo.common.URL;

/**
 * @author zhangqi
 * @date 2019/2/14 上午10:28
 */

public class ThriftAdaptiveExt2 implements AdaptiveExt2 {
    @Override
    public String echo(String msg, URL url) {

        System.out.println("thriftAdaptive");
        return null;
    }
}
