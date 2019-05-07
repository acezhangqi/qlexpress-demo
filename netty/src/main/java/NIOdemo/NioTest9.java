package NIOdemo;

import io.netty.buffer.ByteBuf;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author zhangqi
 * @date 2019/4/2 下午8:26
 */

public class NioTest9 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);
        int messageLength = 2+3+4;
        ByteBuffer[]  buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);
        SocketChannel socketChannel = serverSocketChannel.accept();
        //while (true){
            int byteRead = 0;
            while(byteRead < messageLength){
                long r = socketChannel.read(buffers);
                byteRead+=r;
                System.out.println(byteRead);
            }
             for(int i=0;i<buffers.length;i++){
                buffers[i].flip();
             }
            //long bytesWritten =0;
            //while(bytesWritten<messageLength){
            //    long r = socketChannel.write(buffers);
            //    bytesWritten+=r;
            //}
            //Arrays.asList(buffers).forEach(Buffer::clear);
            //System.out.println("bytesRead:" + byteRead + ",bytesWritten:"+bytesWritten+",messageLength:,"+messageLength);
        //}
        for (int i=0;i<buffers.length;i++){
                    while(buffers[i].hasRemaining()){
                        System.out.println((byte)buffers[i].get());
                    }
                }
        }
    }

/**
 * 永远记住：read是把东西放到buffer中，write是吧东西从buffer种拿出去
 * @param args
 * @throws IOException
 */