package com.shf.pool;

import sun.plugin2.gluegen.runtime.CPU;

import java.util.concurrent.*;

// Executors 工具类、3大方法
public class Demo01 {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5); //创建一个固定的线程池的大小
//        ExecutorService threadPool = Executors.newCachedThreadPool(); //可伸缩的，遇强则强，遇弱则弱


//        CPU密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
//        IO密集型  判断程序中十分耗IO的进程
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        try {
            for (int i = 1; i <= 9; i++) { // java.util.concurrent.RejectedExecutionException:
    //            使用了线程池之后，使用线程来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
