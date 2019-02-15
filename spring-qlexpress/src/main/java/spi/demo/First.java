package spi.demo;

import java.lang.annotation.*;

/**
 * @author zhangqi
 * @date 2019/2/15 上午9:25
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface First {
}
