package com.shf.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个问题
 * 1.标准情况下，两个线程先打印，发送短信还是打电话？ 1/发短信  2/打电话
 * 2.sendSms延迟4秒
 * 3.增加了一个普通方法后,发短信还是hello
 * 4.两个对象,两个同步方法,发短信还是打电话? 打电话
 */
class Test2 {
    public static void main(String[] args) {
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

//        锁的存在
        new Thread(()->{
            phone1.sendSms();
        },"A").start();

//        捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone2.call();
        },"B").start();
    }
}

class Phone2{
//    synchronized 锁的对象就是方法的调用者
//    两个方法用的是同一个锁,谁先拿到谁先执行
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信---sendSms");
    }

    public synchronized void call(){
        System.out.println("打电话---call");
    }

//    这里没有锁! 不是同步方法,不受锁的影响
    public void hello(){
        System.out.println("hello");
    }
}
