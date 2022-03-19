package com.shf4lock;

import java.util.concurrent.TimeUnit;

/**
 * 1个静态的同步方法，1个普通的同步方法
 */
public class Test4 {
    public static void main(String[] args) {
//        两个对象，两把锁
//        两个对象的Class类模板只有一个static，锁的是Class
        Phone4 phone1 = new Phone4();

        new Thread(()->{
            phone1.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone1.cell();
        },"B").start();
    }
}

class Phone4 {
//    synchronized 锁的对象是方法的调用者
//    两个方法用的是同一个锁，谁先拿到谁执行
//    static 静态方法
//    类一加载就有！ 锁的是Class，class全局唯一

    /**
     * new this 具体的一个手机
     * static  Class唯一的一个模板
     *
     */
    public static synchronized void sendSms(){ // 静态同步方法，锁的是Class类模板
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void cell(){ // 普通同步方法，锁的调用者
        System.out.println("打电话");
    }

}
