package com.shf2.demo03;

/**
 * 测试stop
 *
 * 1.建议线程正常停止
 * 2.建议使用标志位
 * 3.不要使用stop或者destroy等过时或者jdk不建议使用的方法
 */
public class TestStop implements Runnable{
//    1.设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("run...Thread"+i++);
        }
    }

//    2.设置一个公开的方法停止线程，转换标志位
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            if (i==900){
//                调用stop方法 停止线程
                testStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }

}
