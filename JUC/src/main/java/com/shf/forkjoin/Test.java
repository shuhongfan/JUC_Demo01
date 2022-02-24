package com.shf.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test3();
    }

    public static void test1(){
        Long sum=0L;
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            sum+=i;
        }

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }

    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0L, 1000000000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);// 提交任务


        Long sum = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }

    public static void test3(){
        long start = System.currentTimeMillis();

//        stream并行流
        long sum = LongStream.rangeClosed(0L, 1000000000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }
}
