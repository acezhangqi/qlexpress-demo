package com.nettyUsage.qq;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author zhangqi
 * @date 2019/3/12 下午4:45
 */

public class Server {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(
            new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline channelPipeline = socketChannel.pipeline();
                    channelPipeline.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
                    channelPipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                    channelPipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                    channelPipeline.addLast(new SimpleChannelInboundHandler<String>() {


                        private  ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

                        @Override
                        protected void channelRead0(ChannelHandlerContext channelHandlerContext,
                                                    String msg) throws Exception {
                                  Channel channel = channelHandlerContext.channel();
                                  channels.forEach(ch->{
                                      if (ch!=channel){
                                          ch.writeAndFlush(ch.remoteAddress()+"发送消息"+msg);
                                      }
                                      else{
                                          ch.writeAndFlush("自己"+msg+"\n");

                                      }
                                  });

                        }

                        @Override
                        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
                            Channel channel = ctx.channel();
                            channels.writeAndFlush("服务器-"+channel.remoteAddress()+"加入");
                            channels.add(channel);
                            super.handlerAdded(ctx);
                        }

                        @Override
                        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
                            Channel channel = ctx.channel();
                            channels.writeAndFlush(channel.remoteAddress()+"离开服务器");
                            channels.remove(channel);
                            super.handlerRemoved(ctx);
                        }

                        @Override
                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                            Channel channel = ctx.channel();
                            System.out.println(channel.remoteAddress() + "上线");
                        }

                        @Override
                        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                            Channel channel = ctx.channel();
                            System.out.println(channel.remoteAddress() + "下线");
                        }
                    });
                }
            });
        ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
        channelFuture.channel().closeFuture().sync();

    }
}
