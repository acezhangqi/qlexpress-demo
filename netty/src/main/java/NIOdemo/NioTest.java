package NIOdemo;

import java.nio.IntBuffer;
import java.util.Random;

/**
 * @author zhangqi
 * @date 2019/3/28 下午9:32
 */

/**
 * java.io  对比 java.Nio
 * java。io 最为核心得概念是Stream,面向流编程。Java总一个流要么是输入流，要么是输出流。不能同时既是输入流又是输出流
 * java.nio有三个核心概念 Selector,Channel,Buffer. 在Java.nio是面相块和buffer编程，buffer本身是一块内存，底层实现上是一个数组，数据的读写都是通过Buffer来实现
 * buffer既可以写耶可以读，通过flip方法进行转化
 * Buffer提供对数据的结构化访问方式，并且可以最终到系统的读写过程
 * Java中的8种原生数据类型都有各自对应的Buffer类型，IntBuffer，LongBuffer
 * Channel指的是可以向其写入数据或者从中读取数据的对象，它类似于java.io种的Stream
 *
 * position,limit,capacity
 *
 *
 */
public class NioTest {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i =0;i<buffer.capacity();i++){
            int randomNum = new Random().nextInt(10);
            buffer.put(randomNum);
        }
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
