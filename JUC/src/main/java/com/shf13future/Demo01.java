package com.shf13future;

import com.sun.xml.internal.ws.util.CompletedFuture;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用： ajax
 */
public class Demo01 {
    @Test
    public void test1() throws ExecutionException, InterruptedException {
//    没有返回值的runAsync 异步回调
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" runAysn=>void");
        });

        System.out.println("1111");
//        获取阻塞执行结果
        completableFuture.get();
    }

//    有返回值 supplyAsync 异步回调
//    ajax 成功和失败的回调
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " supplyAsync=>Integer");
            int i=10/0;   //java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
            return 1024;
        });

        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t); // 正常的返回结果
            System.out.println("u=>" + u); // 错误信息
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return 233;  // 可以获取到错误的返回结果
        }).get());

    }
}
