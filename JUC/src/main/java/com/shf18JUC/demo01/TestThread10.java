package com.shf18JUC.demo01;

//生产者消费者模型---》利用你缓冲区解决：管程法
public class TestThread10 {

}


//生产者
class Productor extends Thread{
    SyncContainer container;
    public Productor(SyncContainer container){
        this.container=container;
    }

//    生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产者"+i+"只鸡");
            container.push(new Chicken(i));
        }
    }
}

//消费者
class Consumer extends Thread{
    SyncContainer container;
    public Consumer(SyncContainer container){
        this.container=container;
    }

    @Override
    public void run() {
        super.run();
    }
}

//产品
class Chicken extends Thread{

    public Chicken(int i) {
    }
}

//缓冲区
class SyncContainer{
//    需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    int count = 0;

//    生产者放入产品
    public synchronized void push(Chicken chicken){
//        如果容器满了，就需要等待消费者消费
        if (count==chickens.length){
//            通知消费者消费，生产等待

        }

//        如果没有满，我们就需要丢入产品
        chickens[count]=chicken;
        count++;

//        可以通知消费者消费了

    }

//    消费消费商品
    public synchronized Chicken pop(){
//        判断能否消费
        if (count==0){

        }

//        如果可以消费
        count--;
        Chicken chicken = chickens[count];

//        吃完了，通知生产者生产
        return chicken;
    }
}