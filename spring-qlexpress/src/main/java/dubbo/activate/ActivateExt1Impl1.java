package dubbo.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author zhangqi
 * @date 2019/2/15 下午6:44
 */

@Activate(group = {"default_group"})
public class ActivateExt1Impl1 implements ActivateExt1 {

    public String echo(String msg) {
        System.out.println("ActivateExt1Impl1");
        return msg;
    }
}
