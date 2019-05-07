package com.nettyUsage.webSocketCode;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.util.Date;

/**
 * @author zhangqi
 * @date 2019/3/14 下午12:51
 */

public class Server {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup  = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,worker).channel(NioServerSocketChannel.class).childHandler(
            new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline channelPipeline = socketChannel.pipeline();
                    channelPipeline.addLast(new HttpServerCodec());
                    channelPipeline.addLast(new ChunkedWriteHandler());
                    channelPipeline.addLast(new HttpObjectAggregator(8192));
                    channelPipeline.addLast(new WebSocketServerProtocolHandler("/wa"));
                    channelPipeline.addLast(new SimpleChannelInboundHandler<TextWebSocketFrame>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext channelHandlerContext,
                                                    TextWebSocketFrame textWebSocketFrame) throws Exception {
                            System.out.println("收到消息"+textWebSocketFrame.text());
                            channelHandlerContext.writeAndFlush(new TextWebSocketFrame("服务器时间"+new Date()));
                        }

                        @Override
                        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
                            System.out.println("handlerAdded" + ctx.channel().id());
                        }

                        @Override
                        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
                            System.out.println("handlerRmoved" + ctx.channel().id());
                        }
                    });
                }
            });
        ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
    }
}
