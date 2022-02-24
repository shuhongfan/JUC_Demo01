package com.shf.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个问题
 * 1.标准情况下，两个线程先打印，发送短信还是打电话？ 1/发短信  2/打电话
 * 2.sendSms延迟4秒
 * 3.增加了一个普通方法后,发短信还是hello
 * 4.两个对象,两个同步方法,发短信还是打电话? 打电话
 * 5.增加两个静态的同步方法,只有一个对象
 * 6.两个对象!增加两个静态的同步方法
 */
class Test3 {
    public static void main(String[] args) {
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

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

class Phone3{
//    synchronized 锁的对象就是方法的调用者
//    两个方法用的是同一个锁,谁先拿到谁先执行
//    static静态方法,类一加载就有了! 锁的class模板
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信---sendSms");
    }

    public static synchronized void call(){
        System.out.println("打电话---call");
    }
}
