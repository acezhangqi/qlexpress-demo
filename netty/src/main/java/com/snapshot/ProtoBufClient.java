package com.snapshot;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @author zhangqi
 * @date 2019/3/18 下午2:24
 */

public class ProtoBufClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {


            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline channelPipeline = socketChannel.pipeline();
                channelPipeline.addLast(new ProtobufVarint32FrameDecoder());
                channelPipeline.addLast(new ProtobufDecoder(DataInfo.Person.getDefaultInstance()));
                channelPipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                channelPipeline.addLast(new ProtobufEncoder());
                channelPipeline.addLast(new SimpleChannelInboundHandler<DataInfo.Person>() {

                    @Override
                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DataInfo.Person person)
                        throws Exception {

                    }

                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        DataInfo.Person person = DataInfo.Person.newBuilder().setAddress("北京").setAge(1).setName("张三").build();
                        ctx.writeAndFlush(person);
                    }
                });
            }
        });
        ChannelFuture channel = bootstrap.connect("localhost",8899).sync();
    }
}
