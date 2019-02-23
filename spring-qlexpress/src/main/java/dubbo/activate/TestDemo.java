package dubbo.activate;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;
import org.junit.Test;

import java.util.List;

/**
 * @author zhangqi
 * @date 2019/2/15 下午6:22
 */

public class TestDemo {

    @Test
    public void testDefault() {
        ExtensionLoader<ActivateExt1> loader = ExtensionLoader.getExtensionLoader(ActivateExt1.class);
        URL url = URL.valueOf("test://localhost/test");
        //查询组为default_group的ActivateExt1的实现
        List<ActivateExt1> list = loader.getActivateExtension(url, new String[]{"group"}, "default_group");
        System.out.println(list.size());
    }


    @Test
    public void testValue() {
        URL url = URL.valueOf("test://localhost/test");
        //根据   key = value1,group =  value
        //@Activate(value = {"value1"}, group = {"value"})来激活扩展
        //url = url.addParameter("value1", "zhangqi");
        //url = url.addParameter("value2","zdfa");
        List<ActivateExt1> list = ExtensionLoader.getExtensionLoader(ActivateExt1.class).getActivateExtension(url, new String[]{"group"}, "value");
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
    }


    @Test
    public void test111(){
        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        System.out.println(protocol);
    }
}
