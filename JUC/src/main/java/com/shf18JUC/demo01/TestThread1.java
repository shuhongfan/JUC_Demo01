package com.shf18JUC.demo01;

//创建线程方式一： ，继承Thread类，重写run()方法，调用start开启线程
//总结 ： 注意，线程开启不一定立即执行，由CPU调度执行
//不建议使用：避免OOP单继承局限性
public class TestThread1 extends Thread{  // 子类继承Thread类具备多线程能力
    @Override
    public void run() {
        super.run();
//        run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码："+i);
        }
    }

    public static void main(String[] args) {
//        创建一个线程对象
        TestThread1 testThread1 = new TestThread1();

//        调用start方法开启线程
//        启动线程： 传入目标对象+Thread对象.start()
        testThread1.start();  // 多条执行路径，主线程和子线程并行交替执行
//        testThread1.run();  // 只有主线程一条执行路径

//        main线程 主线程
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程--"+i);
        }
    }
}
