package NettyByteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author zhangqi
 * @date 2019/4/27 下午1:38
 * 三种缓冲类型
 */

public class ByteBufTest2 {
    public static void main(String[] args) {
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        ByteBuf headBuf = Unpooled.buffer(10);
        ByteBuf directBuf = Unpooled.directBuffer(8);
        compositeByteBuf.addComponents(headBuf,directBuf);
        compositeByteBuf.removeComponent(0);//移出第一个componet，也就是headbuf


    }
}

/**
 * 总结，JDK的bytebuffer和netty的byteBUF区别
 *
 * Heap Buffer
 * 这是最常用的类型，ByteBuf将数据存储在JVM堆空间中，并且将实际的数据存放在byte array中来实现。
 * 优点：由于数据是存储在JVM堆中，所以可以实现快速的创建和快速释放，并且提供了直接访问内部字节数组的方法。
 * 缺点：每次读写数据必须将数组复制到直接缓冲区，再进行网络传输
 *
 * Direct Buffer
 * 在堆外直接分配内存空间，直接缓冲区并不会占用堆的容量空间，因为是操作系统直接在本地内存分配数据。
 * 优点：在socket进行数据传递时，性能非常好，因为数据直接位于操作系统本地内存中，所以不需要从JVM将数据复制到直接缓冲区，性能很好。
 * 缺点：因为DirectBuffer在操作系统内存中，所以分配内存空间和释放比堆要负复杂。所以速度要慢一点
 * Netty通过提供内存池来解决这个问题。内存池是提前申请好的内存空间。直接缓冲区并不支持通过字节数组的方式来访问数据。
 *
 * 重点：对于后端的业务消息编解码来说，推荐使用HeapByteBuf;对于I/O通信线程在读写缓冲区时，推荐使用DirectByteBuf
 *
 * 1.Netty的ByteBuf采用了读写索引分离策略，一个初始化的ByteBuf的readerIndex和writerIndex都为0
 * 当读索引和写索引出于同一个位置时，如果我们继续读取，就会抛异常
 * 2.对于ByteBuf的任何读写都会分别维护读索引和写索引，如果容量不够会自动陪你过扩，JDK会报错。maxCapticy最大容量默认的限制就是Integer.MAX_VALUE；
 *
 *
 */
