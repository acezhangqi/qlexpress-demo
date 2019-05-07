package NIOdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangqi
 * @date 2019/3/28 下午10:22
 */

public class NioTest2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/ace/Downloads/zz/qlexpress-demo/netty/in.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        fileChannel.read(buffer);
        buffer.flip();
        while (buffer.remaining()>0){
            byte i = buffer.get();
            System.out.println((char)i);
        }
        fileInputStream.close();

    }
}
