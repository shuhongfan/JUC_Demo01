package com.shf.function;

import java.util.function.Function;

/**
 * Function函数型接口,有一个输入参数，有一个输出
 * 只要是函数式接口，就可以用lambda表达式简化
 */
public class Demo01 {
    public static void main(String[] args) {

//        工具类：输出输入的值
//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };


        Function function = (s)->s;
        System.out.println(function.apply("asd"));
    }
}
