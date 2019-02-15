package dubbo.activate;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
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
        List<ActivateExt1> list = loader.getActivateExtension(url, new String[]{}, "default_group");
        System.out.println(list.size());
    }
}
