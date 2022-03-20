package com.shf18JUC.demo01;

/**
 * 优先级低只是意味着获得调度的概率低，并不是优先级低就不会被调用=了，这都是看CPU的调度
 */
public class TestThread8 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());

        MYPriority myPriority = new MYPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);

        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();


        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        t5.setPriority(-1);
        t5.start();

        t6.setPriority(11);
        t6.start();
    }
}


class MYPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"===>"+Thread.currentThread().getPriority());
    }
}
