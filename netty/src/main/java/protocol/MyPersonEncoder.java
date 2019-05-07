package protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author zhangqi
 * @date 2019/5/1 下午5:31
 */

public class MyPersonEncoder extends MessageToByteEncoder<PersonProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, PersonProtocol msg, ByteBuf out) throws Exception {
        System.out.println("mypersonEncoder invoker");
         out.writeInt(msg.getLength());
         out.writeBytes(msg.getContent());
    }
}
