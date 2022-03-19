package com.shf4lock;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(()->{
            phone1.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone2.cell();
        },"B").start();
    }
}

class Phone2 {
//    synchronized 锁的对象是方法的调用者
//    两个方法用的是同一个锁，谁先拿到谁执行
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public synchronized void cell(){
        System.out.println("call");
    }

//    增加一个普通方法，这里没有锁，不存在抢锁，不受锁的影响
    public void hello(){
        System.out.println("hello");
    }
}
