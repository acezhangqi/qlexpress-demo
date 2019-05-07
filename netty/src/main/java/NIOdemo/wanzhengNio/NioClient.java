package NIOdemo.wanzhengNio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @author zhangqi
 * @date 2019/4/4 下午8:32
 */

public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        socketChannel.register(selector,SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress("127.0.0.1",8899));
        while(true){
            selector.select();
            Set<SelectionKey> selectionKeySet = selector.keys();
            for (SelectionKey selectionKey:selectionKeySet){
                if (selectionKey.isConnectable()){
                    SocketChannel client = (SocketChannel)selectionKey.channel();
                    if (client.isConnectionPending()){
                        client.finishConnect();
                        ByteBuffer writeBuffer = ByteBuffer.allocate(10213);
                        writeBuffer.put("你好啊".getBytes());
                        writeBuffer.flip();
                        socketChannel.write(writeBuffer);
                    }
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if (selectionKey.isReadable()){
                    SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(512);
                    int read = socketChannel.read(readBuffer);
                    if (read>0){
                        String recivedMessage = new String(readBuffer.array(),0,read);
                        System.out.println(recivedMessage);
                    }
                }
            }
        }
    }
}
