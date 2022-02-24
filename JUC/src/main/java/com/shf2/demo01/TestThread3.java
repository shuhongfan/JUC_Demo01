package com.shf2.demo01;

/**
 * 创建线程方式2： 实现runnable接口，重写run方法，执行线程需丢入runnable接口实现类，调用start方法
 */
public class TestThread3 implements Runnable{

    @Override
    public void run() {
        //        run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码-----"+i);
        }
    }

    public static void main(String[] args) {
//        创建runable接口的实现类对象
        TestThread3 testThread3 = new TestThread3();

//        创建线程对象，通过线程对象来开启我们的线程代理
        Thread thread = new Thread(testThread3);
        thread.start();

        // main线程 主线程
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程-----"+i);
        }
    }
}
