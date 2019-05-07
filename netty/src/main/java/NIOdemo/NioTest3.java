package NIOdemo;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * @author zhangqi
 * @date 2019/3/28 下午10:26
 */

public class NioTest3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Niotest.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        byte[] message = "hello".getBytes();
        for (int i =0;i<message.length;i++){
            buffer.put(message[i]);
        }
        buffer.flip();
        channel.write(buffer);
        fileOutputStream.close();
    }
}
