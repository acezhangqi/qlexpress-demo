package NettyByteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @author zhangqi
 * @date 2019/4/27 上午11:08
 */

public class ByteBufTest1 {
    public static void main
        (String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello",Charset.forName("utf-8"));
        if (byteBuf.hasArray()){
            //如果是真的话，说明这个byteBuf是一个堆上缓冲
            byte[] array = byteBuf.array();
            System.out.println(new String(array, Charset.forName("utf-8")));
            System.out.println(byteBuf);
            System.out.println(byteBuf.arrayOffset());
            //读索引
            System.out.println(byteBuf.readerIndex());
            //可写的
            System.out.println(byteBuf.writerIndex());
            //可写容量。如果不够会自动扩容
            System.out.println(byteBuf.capacity());
            //可读字节数、writerIndex - readerIndex
            int length = byteBuf.readableBytes();
            System.out.println(length);
        }


        for (int i =0;i<byteBuf.capacity();i++){
            System.out.println(byteBuf.readableBytes());
        }

        System.out.println(byteBuf.getCharSequence(0, 4, Charset.forName("utf-8")));
    }
}
