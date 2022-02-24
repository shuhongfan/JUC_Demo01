package com.shf3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test02 {
    @MyAnnotation2(name="sghf")
    public void test(){

    }


    @MyAnnotaton3("ju")
    public void test2(){

    }
}

@Target({ElementType.TYPE,ElementType.METHOD}) // 注解可以用在哪些地方
@Retention(RetentionPolicy.RUNTIME) // 注解在哪些地方有效
@interface MyAnnotation2{
//    注解的参数： 参数类型 + 参数名
    String name() default "";
    int age() default 0;
    int id() default -1; // 如果默认值为-1，代表不存在
    String[] schools() default {"开源"};
}


@interface MyAnnotaton3{
    String value();
}
