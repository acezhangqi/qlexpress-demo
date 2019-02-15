package dubbo.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author zhangqi
 * @date 2019/2/15 下午6:16
 */

@Activate(order = 1, group = {"order"})
public class OrderActivateExtImpl2 implements ActivateExt1 {
    public String echo(String msg) {
        System.out.println("OrderActivateExtImpl2");
        return msg;
    }
}