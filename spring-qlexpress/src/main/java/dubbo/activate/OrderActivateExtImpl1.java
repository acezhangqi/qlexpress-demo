package dubbo.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author zhangqi
 * @date 2019/2/15 下午6:14
 */
@Activate(order = 2,group = {"order"})
public class OrderActivateExtImpl1 implements ActivateExt1{
    @Override
    public String echo(String msg) {
        System.out.println("OrderActivateExtImpl1");
        return msg;
    }
}
