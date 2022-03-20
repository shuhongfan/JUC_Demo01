package com.shf18JUC.demo01;

import com.shf2.demo01.TestThread4;

/**
 * 多个线程同时操作同一个对象
 * 买火车票的例子
 *
 */
public class TestThread3 implements Runnable{

//    票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            System.out.println(Thread.currentThread()+"--->拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread3 ticket = new TestThread3();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛党").start();
    }
}
