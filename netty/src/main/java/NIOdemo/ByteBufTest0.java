package NIOdemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author zhangqi
 * @date 2019/4/26 下午8:09
 */

public class ByteBufTest0 {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(10);
        for (int i =0;i<10;i++){
            byteBuf.writeByte(i);
        }
        for (int i=0;i<byteBuf.capacity();i++){
            System.out.println(byteBuf.readByte());
        }
    }
}
