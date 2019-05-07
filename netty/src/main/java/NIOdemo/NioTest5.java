package NIOdemo;

import java.nio.ByteBuffer;

/**
 * @author zhangqi
 * @date 2019/4/1 下午8:37
 */

public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i =0;i<buffer.capacity();i++){
            buffer.put((byte)i);
        }
       ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
        readOnlyBuffer.position(0);
        readOnlyBuffer.put((byte)2);
    }
}
