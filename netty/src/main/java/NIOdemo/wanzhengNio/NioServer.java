package NIOdemo.wanzhengNio;

import com.sun.org.apache.bcel.internal.generic.Select;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ServerChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangqi
 * @date 2019/4/3 下午12:51
 */

public class NioServer {

    //用于存储客户端对应的SocketChanel
   private static  Map<String,SocketChannel>  mapClient = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        while(true){
            try{
                 int i = selector.select();
                Set<SelectionKey> selectionKeys = selector.keys();
                System.out.println(i);
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    final SocketChannel client;
                    SelectionKey selectionKey =iterator.next();
                    if(selectionKey.isAcceptable()){
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                        client = serverSocketChannel1.accept();
                        client.configureBlocking(false);
                        client.register(selector,SelectionKey.OP_READ);
                        String key = "["+UUID.randomUUID().toString()+"]";
                        mapClient.put(key,client);
                    }else if (selectionKey.isReadable()){
                       client = (SocketChannel) selectionKey.channel();
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        int count = client.read(readBuffer);
                        if(count > 0){
                            readBuffer.flip();
                            Charset charset = Charset.forName("utf-8");
                            String receivedMessage = String.valueOf(charset.decode(readBuffer).array());
                            System.out.println(receivedMessage);
                            String sendKey = null;
                            for (Map.Entry<String,SocketChannel> entry:mapClient.entrySet()){
                                if (entry.getValue().equals(client)){
                                     sendKey = entry.getKey();
                                     break;
                                }
                            }
                            //广播：
                            for (Map.Entry<String,SocketChannel> entry:mapClient.entrySet()){
                                SocketChannel value = entry.getValue();
                                ByteBuffer buffer = ByteBuffer.allocate(1024);
                                buffer.put((sendKey+"发送消息:"+receivedMessage).getBytes());
                                buffer.flip();
                                value.write(buffer);
                            }

                        }
                    }

                }
                selectionKeys.clear();
            }catch (Exception e){
             e.printStackTrace();
            }

        }
    }


}
