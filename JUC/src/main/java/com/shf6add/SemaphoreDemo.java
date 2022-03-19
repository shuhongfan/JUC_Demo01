package com.shf6add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 减法计数器
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
//        默认线程数量：停车位!  限流！
//        作用： 多个
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
//                    获得，假设如果已经满了，等待，等待被释放为止
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    释放，会将当前的信号量释放+1，然后唤醒等待的线程
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
