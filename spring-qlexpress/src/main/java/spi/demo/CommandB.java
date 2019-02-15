package spi.demo;

/**
 * @author zhangqi
 * @date 2019/2/13 下午7:48
 */

public class CommandB implements Command{
    @Override
    public String doCommand() {
        System.out.println("commandB");
        return "commandB";
    }
}
