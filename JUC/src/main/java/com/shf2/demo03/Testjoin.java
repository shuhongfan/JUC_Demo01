package com.shf2.demo03;

public class Testjoin implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Testjoin testjoin = new Testjoin();
        Thread thread = new Thread(testjoin);
        thread.start();

//        主线程

        for (int i = 0; i < 500; i++) {
            if (i==200){
                thread.join(); // 插队
            }
            System.out.println("main"+i);
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("VIP 线程来了");
        }
    }
}
