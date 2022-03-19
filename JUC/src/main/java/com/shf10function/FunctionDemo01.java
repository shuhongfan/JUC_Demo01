package com.shf10function;

import java.util.function.Function;

/**
 * Function 函数式接口，有一个输入参数，有一个输出
 * 只要是 函数式接口 可以用lambda表达式简化
 */
public class FunctionDemo01 {
    public static void main(String[] args) {
//        工具类：输出拿到值
//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String o) {
//                return null;
//            }
//        };

        Function<String, String> function = str-> str;

        System.out.println(function.apply("asd"));
    }
}


/**
 * @FunctionalInterface
 * public interface Function<T, R> {  // 传入参数T，返回类型R
 *  R apply(T t);
 */