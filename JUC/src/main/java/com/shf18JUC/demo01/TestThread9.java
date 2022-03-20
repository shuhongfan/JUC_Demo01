package com.shf18JUC.demo01;

public class TestThread9 {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
//        设置为守护线程
        thread.setDaemon(true);  //默认是false表示用户线程，正常的线程都是用户线程...
        thread.start(); // 上帝守护线程启动

        Thread thread1 = new Thread(you); // 你 用户线程启动....
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("-====GoofBye! world!====");
    }
}


class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑你");
        }
    }
}