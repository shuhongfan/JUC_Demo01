package com.shf3;

import java.lang.annotation.*;

/**
 * 测试元注解
 */
public class Test01 {
    @MyAnnotation
    public void test(){

    }
}

//Target表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//Retention 表示我们的注解在什么地方还有效
@Retention(value = RetentionPolicy.CLASS)
//Documented表示是否将我们的注解生成在JAVADOC中
@Documented
//Inherited子类可以继承父类的注解
@Inherited
@interface MyAnnotation{ // 自定义注解

}
