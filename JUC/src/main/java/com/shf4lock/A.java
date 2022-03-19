package com.shf4lock;

import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 面试： 单例模式、排序算法、生产者和消费者、死锁
 * <p>
 * 线程之间的通信问题：生产者和消费者问题！ 等待唤醒，通知能唤醒
 * 线程交替执行 A  B 操作同一个变量  num=0
 * A  num+1
 * B num-1
 */
public class A {
    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class Data {
    private int number = 0;

    //    +1
    public synchronized void increment() throws InterruptedException {
        while (number != 0) { // 0
//            等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+">>"+number);
//        通知其他线程，我+1完毕了
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {  // 1
//            等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+">>"+number);
//        通知其他线程，我-1完毕了
        this.notifyAll();
    }
}

class Data2 {
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //    +1
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) { // 0
    //            等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+">>"+number);
//        通知其他线程，我+1完毕了
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {  // 1
    //            等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+">>"+number);
//        通知其他线程，我-1完毕了
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
