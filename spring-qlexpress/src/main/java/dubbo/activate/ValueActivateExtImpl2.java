package dubbo.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author zhangqi
 * @date 2019/2/15 下午6:16
 */

@Activate(value = {"value2"}, group = {"value2"})
public class ValueActivateExtImpl2 implements ActivateExt1 {
    public String echo(String msg) {
        System.out.println("ValueActivateExtImpl2");
        return msg;
    }
}