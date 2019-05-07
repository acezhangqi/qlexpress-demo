package NIOdemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangqi
 * @date 2019/4/2 下午12:39
 */

public class NioTest6 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile  = new RandomAccessFile("/Users/ace/Downloads/zz/qlexpress-demo/netty/in.txt","rw");
        FileChannel fileChannl = randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannl.map(FileChannel.MapMode.READ_WRITE,0,5);
        mappedByteBuffer.put(0,(byte)'a');
        mappedByteBuffer.put(3,(byte)'4');
        randomAccessFile.close();
    }
}
