package NIOdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author zhangqi
 * @date 2019/4/9 下午10:25
 */

public class NioTest13 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("in.txt","r");
        RandomAccessFile randomAccessFile1  =new RandomAccessFile("out.txt","rw");
        long inputLength = new File("in.txt").length();
        FileChannel inputFileChannel = randomAccessFile.getChannel();
        FileChannel outputFileChannel = randomAccessFile1.getChannel();
        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY,0,inputLength);
        System.out.println("--------------");
        Charset.availableCharsets().forEach((k,v)->{
            System.out.println(k + ":" + v);
        });
        Charset charset = Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();
        CharBuffer charBuffer  = decoder.decode(inputData);
        ByteBuffer outputData = encoder.encode(charBuffer);
        outputFileChannel.write(outputData);
        randomAccessFile.close();
        randomAccessFile1.close();
    }
}
