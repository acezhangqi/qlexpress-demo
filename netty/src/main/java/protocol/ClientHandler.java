package protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @author zhangqi
 * @date 2019/5/1 下午5:48
 */

public class ClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {

    private int count = 0;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        System.out.println("client Handler invoker");
        int length = msg.getLength();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i =0;i<10;i++){
            String messageStr = "message from client";
            byte[] mesaageByte = messageStr.getBytes(Charset.forName("utf-8"));
            int length = messageStr.getBytes().length;
            PersonProtocol personProtocol = new PersonProtocol();
            personProtocol.setLength(length);
            personProtocol.setContent(mesaageByte);
            ctx.writeAndFlush(personProtocol);

        }
    }
}
