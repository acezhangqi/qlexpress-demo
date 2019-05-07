package selfEncoderAndDecoder;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author zhangqi
 * @date 2019/4/30 下午1:18
 */

/**
 *
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        channelPipeline.addLast(new MyLong2ByteEncoder());
        channelPipeline.addLast(new MyByteDecoder2());
        channelPipeline.addLast(new MySerHandler());
    }
}
