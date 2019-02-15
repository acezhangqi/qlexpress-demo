package spi.demo;

/**
 * @author zhangqi
 * @date 2019/2/13 下午7:47
 */
@First
public class CommandA implements Command{

    @Override
    public String doCommand() {
        System.out.println("commandA");
        return "commandA";
    }
}
