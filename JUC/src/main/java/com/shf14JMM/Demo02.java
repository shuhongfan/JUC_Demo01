package com.shf14JMM;

//不保证原子性

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 如果不加lock和synchronized，怎样保证原子性？
 */
public class Demo02 {
//    原子类的Integer
    private volatile static AtomicInteger num=new AtomicInteger();

    public static void add(){
//        num++; // 不是一个原子性操作
        num.getAndIncrement();  // AtomicInteger+1方法
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() +"  "+num);
    }
}
