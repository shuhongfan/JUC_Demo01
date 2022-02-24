package com.shf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
//        });
//        System.out.println("111");
//        completableFuture.get();

//        有返回值的supplyAsync异步回调
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync=>Integer");
            int i =10/0;
            return 1024;
        });

        Integer exceptionally = completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t); // 正常的返回结果
            System.out.println("u=>" + u); // 错误信息：java.lang.ArithmeticException: / by zero
        }).exceptionally((e) -> {
            String message = e.getMessage();
            System.out.println(message);
            return 233; // 课程获取到错误的返回结果
        }).get();
        System.out.println(exceptionally);
    }
}
