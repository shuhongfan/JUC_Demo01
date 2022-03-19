package com.shf9bq;

import org.junit.Test;

/**
 * 阻塞队列
 */
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
    /**
     * 抛出异常  add  remove
     */
    @Test
    public void test1(){
//        队列的大小
        java.util.concurrent.ArrayBlockingQueue<Object> blockingQueue = new java.util.concurrent.ArrayBlockingQueue<>(3);

//        java.lang.IllegalStateException: Queue full
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d"));

        System.out.println("================================");
        System.out.println(blockingQueue.element()); // 查看队首元素是谁
        System.out.println("================================");

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
    }

    /**
     * 有返回值，没有异常 offer  poll
     */
    @Test
    public void test2(){
        java.util.concurrent.ArrayBlockingQueue<Object> blockingQueue = new java.util.concurrent.ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d")); // false 不抛出异常

        System.out.println("=================================");
        System.out.println(blockingQueue.peek()); // 检测队首元素
        System.out.println("=================================");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }


    /**
     * 等待、阻塞（一直阻塞）
     */
    @Test
    public void test3() throws InterruptedException {
        java.util.concurrent.ArrayBlockingQueue<Object> blockingQueue = new java.util.concurrent.ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("c");  // 队列没有位置了，一直阻塞
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
    }

    /**
     * 等待，阻塞（等待超时）
     */
    @Test
    public void test4() throws InterruptedException {
        java.util.concurrent.ArrayBlockingQueue<Object> blockingQueue = new java.util.concurrent.ArrayBlockingQueue<>(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d",2, TimeUnit.SECONDS);  // 等待超过2秒就退出
        System.out.println("=========================");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        blockingQueue.poll(2,TimeUnit.SECONDS);
    }
}
