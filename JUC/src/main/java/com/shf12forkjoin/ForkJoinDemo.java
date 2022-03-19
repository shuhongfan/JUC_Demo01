package com.shf12forkjoin;

import org.junit.Test;

import java.util.concurrent.RecursiveTask;

/**
 * Forkjoin在JDK1.7，并行执行任务！提高效率！大数据量！
 * 大数据：Map Reduce（把大任务拆分为小人物）
 *
 * Forkjoin特点： 工作窃取
 *     里面维护的都是双端队列
 *
 * 求和计算的任务！
 * 3000  6000(ForkJoin)  9000(stream并行流)
 *
 * 如何使用forkjoin
 * 1.forkjoinPool通过它来执行
 * 2.计算任务 forkjoinPool。execute（ForkJoinTask<?> task）
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;

//    临界值 1万
    private Long temp =10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Test
    public void test() {

    }

//    计算方法
    @Override
    protected Long compute() {
        if ((end-start)>temp){
            Long sum = 0L;
            for (int i = 0; i < 100000000; i++) {
                sum+=i;
            }
            return sum;
        } else { //forkjoin
            long middle = (start-end) / 2;  // 中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();  // 拆分任务，把任务压入线程队列

            ForkJoinDemo task2 = new ForkJoinDemo(middle + 1, end);
            task2.fork();

            return task1.join() + task2.join();
        }

    }
}
