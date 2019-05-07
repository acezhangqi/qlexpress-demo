package NIOdemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author zhangqi
 * @date 2019/4/28 下午10:07
 */

public class RefrenceCountT {
    public static void main(String[] args) {
        ByteBuf parent = Unpooled.directBuffer();
        try{
        for (int i=0;i<16;i++){
            ByteBuf drived =  parent.copy();
            //drived.retain();
            precess(drived);
        }}finally {
            parent.release();
        }
    }

    private static void precess(ByteBuf drived) {
        drived.release();
    }
}
