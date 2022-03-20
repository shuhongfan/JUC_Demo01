package com.shf18JUC.demo01;

import com.shf2.demo03.Testjoin;

//测试join方法  想象为插队
public class TestThread6 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestThread6 testThread6 = new TestThread6();
        Thread thread = new Thread(testThread6);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            if (i==200){
                thread.join();  // 插队
            }
            System.out.println("main"+i);
        }
    }
}
