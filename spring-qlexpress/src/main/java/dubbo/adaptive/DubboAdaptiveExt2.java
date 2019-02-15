package dubbo.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;

import java.util.Date;

/**
 * @author zhangqi
 * @date 2019/2/14 上午10:26
 */

public class DubboAdaptiveExt2 implements AdaptiveExt2 {
    @Override
    public String echo(String msg, URL url) {

        System.out.println("DubboAdaptiveExt2");
        return null;
    }

        public static void main(String[] args) {
       Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        }
    }

