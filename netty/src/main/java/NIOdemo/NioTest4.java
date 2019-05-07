package NIOdemo;

import java.nio.ByteBuffer;

/**
 * @author zhangqi
 * @date 2019/4/1 下午8:20
 */

public class NioTest4 {
    public static void main(String[] args) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(10);
        for (int i =0 ;i<bytebuffer.capacity();i++){
            bytebuffer.put((byte)i);
        }
        bytebuffer.position(2);
        bytebuffer.limit(6);
        ByteBuffer sliceBuffer= bytebuffer.slice();
        for (int i =0;i<sliceBuffer.capacity();i++){
            byte b = sliceBuffer.get(i);
            b *=2;
            sliceBuffer.put(i,b);
        }

        bytebuffer.position(0);
        bytebuffer.limit(bytebuffer.capacity());

        while(bytebuffer.hasRemaining()){
            System.out.println(bytebuffer.get());
        }
    }
}
