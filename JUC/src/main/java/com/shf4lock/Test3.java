package com.shf4lock;

import java.util.concurrent.TimeUnit;

/**
 * 增加两个静态同步方法
 */
public class Test3 {
    public static void main(String[] args) {
//        两个对象，两把锁
//        两个对象的Class类模板只有一个static，锁的是Class
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

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

class Phone3 {
//    synchronized 锁的对象是方法的调用者
//    两个方法用的是同一个锁，谁先拿到谁执行
//    static 静态方法
//    类一加载就有！ 锁的是Class，class全局唯一
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public static synchronized void cell(){
        System.out.println("call");
    }

//    增加一个普通方法，这里没有锁，不存在抢锁，不受锁的影响
    public void hello(){
        System.out.println("hello");
    }
}
