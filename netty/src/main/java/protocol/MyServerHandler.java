package protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangqi
 * @date 2019/5/1 下午5:33
 */

public class MyServerHandler extends SimpleChannelInboundHandler<PersonProtocol> {


    private int count =0;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
         int length = msg.getLength();
         byte[] content = msg.getContent();
        System.out.println("myserverHandler invoker,"+count++);
        System.out.println("接收到客户端消息长度" + length);
        System.out.println("接收到客户端消息内容:" + new String(content, Charset.forName("utf-8")));
        String responseMessage = UUID.randomUUID().toString();
        int responseLength  = responseMessage.getBytes().length;
        byte[] responseContent = responseMessage.getBytes();
        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setContent(responseContent);
        personProtocol.setLength(responseLength);
        ctx.channel().writeAndFlush(personProtocol);
    }
}
