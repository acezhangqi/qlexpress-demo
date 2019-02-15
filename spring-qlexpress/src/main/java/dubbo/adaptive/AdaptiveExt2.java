package dubbo.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author zhangqi
 * @date 2019/2/14 上午10:25
 */
@SPI
public interface AdaptiveExt2 {

    @Adaptive
    String echo(String msg, URL url);
}
