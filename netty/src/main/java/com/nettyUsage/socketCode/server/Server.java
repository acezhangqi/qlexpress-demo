package com.nettyUsage.socketCode.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;

/**
 * @author zhangqi
 * @date 2019/3/12 上午10:58
 */

public class Server {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossgroup = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        final AttributeKey<String> id  = AttributeKey.newInstance("ID");
        serverBootstrap = serverBootstrap.group(bossgroup,worker).channel(NioServerSocketChannel.class);
        serverBootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS,5000).attr(id,"123").handler(new LoggingHandler(LogLevel.DEBUG)).childHandler(
            new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) {
                    ChannelPipeline channelPipeline = socketChannel.pipeline();
                    channelPipeline.addLast("first",new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
                  //  channelPipeline.addLast("sconde",new LengthFieldPrepender(4));
                    channelPipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                    channelPipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                    channelPipeline.addLast(new SimpleChannelInboundHandler<String>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext ctx, String s) {
                           ctx.channel().writeAndFlush("收到请求");
                            ctx.writeAndFlush("收到请求");
                        }

                        @Override
                        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                            cause.printStackTrace();

                        }
                    });
            }
    });
         ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
         channelFuture.channel().closeFuture().sync();
}
}
