package dubbo.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author zhangqi
 * @date 2019/2/15 下午6:16
 */

@Activate( group = {"value"})
public class ValueActivateExtImpl implements ActivateExt1 {
    public String echo(String msg) {
        System.out.println("ValueActivateExtImpl");
        return msg;
    }
}