package com.ercargo.learn.concurrency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE  不推荐的写法标识
 */
@Target(ElementType.TYPE)  //指注解作用的目标，给类加上注解
@Retention(RetentionPolicy.SOURCE) //注解存在的范围   说明编译时就会被忽略， 实际编程中用RUNTIME
public @interface NotRecommend {
    /**
     * 给一个默认注解的名称
     * @return
     */
    String value() default "";
}
