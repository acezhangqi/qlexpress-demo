package selfEncoderAndDecoder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhangqi
 * @date 2019/4/30 下午1:35
 */

public class MySerHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {
        System.out.println("myserverHandler is invoker");
        System.out.println(msg);
        ctx.writeAndFlush(123213L);
    }
}
