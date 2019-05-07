package com.nettyUsage.socketCode.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author zhangqi
 * @date 2019/3/12 下午1:04
 */

public class Client {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossgroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(bossgroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline channelPipeline = socketChannel.pipeline();
                channelPipeline.addLast("first",new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
                channelPipeline.addLast("sconde",new LengthFieldPrepender(4));
                channelPipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                channelPipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                channelPipeline.addLast(new SimpleChannelInboundHandler<String>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, String s)
                        throws Exception {
                        System.out.println(ctx.channel().remoteAddress());
                        System.out.println("client output:" + s);
                        ctx.writeAndFlush("from client"+"现在");
                    }

                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        ctx.writeAndFlush("客户端的问候");
                        super.channelActive(ctx);
                    }
                });
        }});
        ChannelFuture channelFuture = bootstrap.connect("localhost",8899).sync();
        channelFuture.channel().closeFuture().sync();
    }
}
