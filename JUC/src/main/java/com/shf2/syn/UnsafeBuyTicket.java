package com.shf2.syn;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"我").start();
        new Thread(station,"你").start();
        new Thread(station,"黄牛").start();
    }
}


class BuyTicket implements Runnable{

//    票
    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
//        买票
        while (flag){
            buy();
        }
    }

//    synchronized 同步方法 锁的是this
    private synchronized void buy(){
//        判断是否有票
        if (ticketNums<=0){
            return;
        }

//        模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        买票
        System.out.println(Thread.currentThread().getName()+" 拿到"+ticketNums--);
    }
}
