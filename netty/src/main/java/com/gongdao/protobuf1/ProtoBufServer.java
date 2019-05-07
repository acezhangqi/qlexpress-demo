package com.gongdao.protobuf1;

import com.snapshot.DataInfo;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @author zhangqi
 * @date 2019/3/18 下午2:09
 */

public class ProtoBufServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(
            new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline channelPipeline = socketChannel.pipeline();
                    channelPipeline.addLast(new ProtobufVarint32FrameDecoder());
                    channelPipeline.addLast(new ProtobufDecoder(DataInfo.Person.getDefaultInstance()));
                    channelPipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                    channelPipeline.addLast(new ProtobufEncoder());
                    channelPipeline.addLast(new SimpleChannelInboundHandler<DataInfo.Person>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Person person)
                            throws Exception {
                            System.out.println(person.getAge() + "," + person.getName() + "," + person.getAddress());
                        }

                    });
                }
            });
        ChannelFuture channelFuture = bootstrap.bind(8899).sync();
        channelFuture.channel().closeFuture().sync();
    }
}
