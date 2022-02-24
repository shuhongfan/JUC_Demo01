package com.shf.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    public static void test1(){
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

//        抛出异常 java.lang.IllegalStateException: Queue full
//        System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.element()); //查看队首元素是谁
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

    }

    public static void test2(){
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // false  不抛出异常
//        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll()); //null 不抛出异常
    }

//    等待，阻塞
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

//        一直阻塞
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        blockingQueue.put("d");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

//    等待超时
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d",2, TimeUnit.SECONDS);

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
    }
}
