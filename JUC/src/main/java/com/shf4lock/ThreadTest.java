package com.shf4lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    @Test
    public void test1(){
//       并发： 多线程操作
        Ticket2 ticket = new Ticket2();
        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}

//资源类 OOP
class Ticket{
//    属性、方法
    private int number = 50;

//    synchronized
//    买票的方式
    public synchronized void sale(){
        if (number>0){
            System.out.println(Thread.currentThread().getName()+"卖出了"+number--+"票,剩余："+number);
        }
    }
}

class Ticket2{
//    属性、方法
    /**
     * 公平锁：十分公平、可以插队（默认）
     * 非公平锁：十分不公平，可以插队（默认）
     *
     *
     * lock三部曲
     * 1.new ReentrantLock();
     * 2.lock.lock(); 加锁
     * 3.lock.unlock(); 解锁
     *
     * synchronized 和 lock区别
     * 1 Synchronized内置的java关键字，Lock是一个Java类
     * 2 Synchronized 无法判断获取锁的状态，Lock可以判断是否获取到了锁
     * 3 Synchronized 会自动释放锁,lock锁必须要手动释放锁！如果不释放锁，死锁
     * 4 Synchronized 线程1（获得锁，阻塞）、线程2（等等，傻傻的等）；lock锁就不一定会等待下去
     * 5 Synchronized 可重入锁，不可以中断的，非公平；Lock 可重入锁，可以判断锁，非公平（可以自己设置）
     * 6 Synchronized 适合少量的代码同步问题，Lock适合锁大量的同步代码
     *
     * 锁的是什么，如何判断锁的是谁！
     * 老版 Synchronized  wait  notify
     *
     * */
    private int number = 30;

    Lock lock = new ReentrantLock();

    public synchronized void sale(){
//        加锁
        lock.lock();

        if (number>0){
            System.out.println(Thread.currentThread().getName()+"卖出了"+number--+"票,剩余："+number);
        }

        lock.unlock(); //解锁
    }
}
