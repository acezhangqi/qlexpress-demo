package NIOdemo;

/**
 * @author zhangqi
 * @date 2019/4/29 下午12:54
 */

/**
 * Netty处理器可以分为两类，入站处理器和出站处理器，
 * 2.入站处理器的顶层是ChannelInboundHandler，出站处理器的顶层是ChannelOutboundHandler
 * 3.数据处理时常用的各种解码器本质上都是处理器
 * 4.编码：本质是一种出站处理器，因此编码一定是一种ChannelOutboundHandler
 * 5.解码：本质是一种入站处理器，因此解码一定是一种ChannelInboundHandler
 * 6.在Netty中，编码器通常以XXXEncoder命名，解码器通常以XXXDecoder命名
 * 7.前一个处理器的出来的数据要和后一个处理器入参相匹配，否则就会有问题
 * 8.TCP粘包和拆包会对消息的处理产生问题 Netty提供了Frame Dectection系列的一些双处理器
 *
 *
 */
public class HandlerTest {
}
