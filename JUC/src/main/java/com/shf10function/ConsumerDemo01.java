package com.shf10function;

import java.util.function.Consumer;

/**
 * Consumer 消费型接口：只有输入，没有返回值
 * @FunctionalInterface
 * public interface Consumer<T> {
 *  void accept(T t);
 */
public class ConsumerDemo01 {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        Consumer<String> consumer = s-> System.out.println(s);

        consumer.accept("sdfd");
    }
}
