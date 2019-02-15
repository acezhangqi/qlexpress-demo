package dubbo.activate;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author zhangqi
 * @date 2019/2/15 下午6:09
 */
@SPI
public interface ActivateExt1 {

    String echo(String msg);

}
