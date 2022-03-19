package com.shf12forkjoin;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Demo01 {
    @Test
    public void test1(){ // 3050
        Long sum=0L;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000L; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"时间："+(end-start));
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException { // 502
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0L, 1000000000L);
//        forkJoinPool.execute(task);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);// 提交任务
        Long sum = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"时间："+(end-start));
    }

    @Test
    public void test3(){  // 117
        long start = System.currentTimeMillis();
        long sum = LongStream  // 并行流
                .rangeClosed(0L, 1000000000L)
                .parallel()
                .reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"时间："+(end-start));
    }
}
