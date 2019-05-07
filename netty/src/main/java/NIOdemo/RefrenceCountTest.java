package NIOdemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledDirectByteBuf;

/**
 * @author zhangqi
 * @date 2019/4/28 下午8:53
 */

public class RefrenceCountTest {
    public static void main(String[] args) {
        ByteBuf byteBuf =Unpooled.directBuffer();
        System.out.println(byteBuf.refCnt());
        byteBuf.release();
        /**
         * 当引用计数为0的时候，这个数据会被放回池空间或者回收，这取决于用的是pooled还是unpooled
         */
        System.out.println(byteBuf.refCnt());
    }
}
