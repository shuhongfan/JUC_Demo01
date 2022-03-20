package com.shf18JUC.demo01;

//1.建议线程正常停止---》利用次数，不建议死循环
//2.建议使用标志位--》设置加一个标志位
//3.不要使用stop或者destroy等过时或者JDK不建议使用的方法
public class TestThread5 implements Runnable{
//    1.设置一个标识位
    private boolean flag=true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run...Thread"+i++);
        }
    }

//    设置一个公开的方法停止线程，转换标志位
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        TestThread5 testThread5 = new TestThread5();

        new Thread(testThread5).start();

        for (int i = 0; i < 1000; i++) {
            if (i==900){
                testThread5.stop();
            }
        }
    }
}
