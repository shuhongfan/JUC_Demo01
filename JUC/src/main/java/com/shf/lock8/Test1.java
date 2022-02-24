package com.shf.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个问题
 * 1.标准情况下，两个线程先打印，发送短信还是打电话？ 1/发短信  2/打电话
 * 2.sendSms延迟4秒
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

//        锁的存在
        new Thread(()->{
            phone.sendSms();
        },"A").start();

//        捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();
    }
}

class Phone{
//    synchronized 锁的对象就是方法的调用者
//    两个方法用的是同一个锁,谁先拿到谁先执行
    public synchronized void sendSms(){
        System.out.println("发短信---sendSms");
    }

    public synchronized void call(){
        System.out.println("打电话---call");
    }
}
