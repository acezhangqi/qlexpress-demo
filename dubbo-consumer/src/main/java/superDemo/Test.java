package superDemo;

import org.springframework.beans.BeanUtils;
import org.springframework.core.env.AbstractEnvironment;

/**
 * @author zhangqi
 * @date 2019/3/7 下午1:41
 */

public class Test {

    public static void main(String[] args) {
       Aimpl a  = new Aimpl();
       getaaa(a,Aimpl.class);
    }

    public static <T> void getaaa(T t,Class<T> clazz){
        if (clazz.equals(Aimpl.class) || clazz.getSuperclass().equals(AbstractA.class)){
            System.out.println(((Aimpl)t).age);
        }
        ACopy aCopy = new ACopy();
        BeanUtils.copyProperties(aCopy,t);
        System.out.println(t);
    }
}
