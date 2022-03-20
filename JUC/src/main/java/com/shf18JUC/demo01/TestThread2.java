package com.shf18JUC.demo01;

//创建线程方式2： 实现runnable接口，重写run方法，
// 执行线程需要丢入runnable接口实现类，调用start方法
//推荐使用：避免单继承局限性，灵活方便，方便同一个对象被多个线程使用
public class TestThread2 implements Runnable{ // 实现接口Runnable具有多线程能力
    @Override
    public void run() {
//        run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码----"+i);
        }
    }

    public static void main(String[] args) {
//        创建runnable接口实现类对象
        TestThread2 testThread2 = new TestThread2();

//        启动线程： 传入目标对象+Thread对象.start()
        new Thread(testThread2).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程----"+i);
        }
    }
}
