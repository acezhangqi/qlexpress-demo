package dubbo.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author zhangqi
 * @date 2019/2/15 下午6:11
 */
@Activate(group = {"group1","group2"})
public class GroupActivateExtImpl implements ActivateExt1 {
    @Override
    public String echo(String msg) {
        System.out.println("GroupActivateExtImpl");
        return msg;
    }
}
