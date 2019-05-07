package selfEncoderAndDecoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author zhangqi
 * @date 2019/4/30 下午2:34
 */

/**
 * 发送的数据必须是Long和泛型一直，或者直接写一个ByteBuf，原因是在TypeParameterMatcher中的匹配
 * 关于Netty编解码器的重要结论：
 * 1.无论是编码器还是解码器，所接收的消息类型要与泛型一致，或者是ByteBuf，否则就会跳过这个编解码器
 * 2.在解码器进行数据解码时，记得一定要判断缓冲是否足够用，否则会有一些粘包拆包问题
 * 就是这句话in.readableBytes() >=8
 *
 * Netty自己提供的一些编解码器：LineBasedFrameDecoder 基于行将消息进行分割，每读完一行进行解码
 *FixedLengthFrameDecoder 根据固定字符串长度
 *DelimiterBasedFrameDecoder 根据自己定义的
 *
 */
public class MyLong2ByteEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("encode invoked");
        System.out.println(msg);
        out.writeLong(msg);
    }
}
