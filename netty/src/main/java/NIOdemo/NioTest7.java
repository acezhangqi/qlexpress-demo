package NIOdemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author zhangqi
 * @date 2019/4/2 下午8:21
 */

public class NioTest7 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile  = new RandomAccessFile("/Users/ace/Downloads/zz/qlexpress-demo/netty/in.txt","rw");
        FileChannel fileChannl = randomAccessFile.getChannel();
        //3-6位被锁定为共享锁，读并发可以，写排他
        FileLock fileLock = fileChannl.lock(3,6,true);

    }
}
