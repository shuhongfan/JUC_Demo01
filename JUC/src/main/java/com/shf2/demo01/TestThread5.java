package com.shf2.demo01;

/**
 * 多线程同时操作一个对象
 * 买火车票例子
 *
 * 发现问题： 多个线程操作同一个资源的情况下，线程不安全
 */
public class TestThread5 implements Runnable{

//    票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }

//            模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  拿到了第 "+ticketNums--+" 张票");
        }
    }

    public static void main(String[] args) {
        TestThread5 testThread5 = new TestThread5();

        new Thread(testThread5,"小明").start();
        new Thread(testThread5,"老师").start();
        new Thread(testThread5,"黄牛1").start();
        new Thread(testThread5,"黄牛2").start();
        new Thread(testThread5,"黄牛3").start();
    }
}
