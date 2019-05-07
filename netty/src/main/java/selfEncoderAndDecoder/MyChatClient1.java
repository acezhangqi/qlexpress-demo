package selfEncoderAndDecoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author zhangqi
 * @date 2019/3/14 上午9:10
 */

public class MyChatClient1 {

    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {


            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline channelPipeline = socketChannel.pipeline();
                channelPipeline.addLast(new MyLong2ByteEncoder());
                channelPipeline.addLast(new MyByteDecoder2());
                channelPipeline.addLast(new SimpleChannelInboundHandler<Long>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Long s)
                        throws Exception {
                        System.out.println(s);
                    }

                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        ctx.writeAndFlush(123123L);
                    }
                });
            }
        });
        Channel channel =bootstrap.connect("localhost",8899).sync().channel();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (;;){
            channel.writeAndFlush(br.readLine()+"\r\n");
        }
    }
}
