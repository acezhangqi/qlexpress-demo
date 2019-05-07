package com.nettyUsage.qq;

import io.netty.bootstrap.Bootstrap;
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

/**
 * @author zhangqi
 * @date 2019/3/14 上午9:10
 */

public class MyChatClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {


            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline channelPipeline = socketChannel.pipeline();
                channelPipeline.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
                channelPipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                channelPipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                channelPipeline.addLast(new SimpleChannelInboundHandler<String>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s)
                        throws Exception {
                        System.out.println(s);
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
