package com.shf2.syn;

import lombok.SneakyThrows;

public class TestPC {
    public static void main(String[] args) {
        SyncContainer container = new SyncContainer();
        new Productor(container).run();
        new Consumer(container).run();
    }
}

//生产者
class Productor extends Thread{
    SyncContainer container;

    public Productor(SyncContainer container) {
        this.container = container;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}

//消费者
class Consumer extends Thread{
    SyncContainer container;

    public Consumer(SyncContainer container) {
        this.container = container;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("消费了-->"+container.pop().id+"只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//产品
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SyncContainer{
//    需要一个容器大小
    Chicken[] chickens = new Chicken[10];

//    容器计数器
    int count=0;

//    生产者放入产品
    public synchronized void push(Chicken chicken) throws InterruptedException {
//        如果容器满了，就需要等待消费者消费
        if (count==chickens.length){
//            通知消费者消费，生产等待
            this.wait();
        }

//        如果没有满，我们就需要丢入产品
        chickens[count]=chicken;
        count++;

//        可以通知消费者消费了
        this.notifyAll();

    }

//    消费者消费产品
    public synchronized Chicken pop() throws InterruptedException {
//        判断能否消费
        if (count==0){
//            等待生产者生产，消费者等待
            this.wait();
        }

//        如果可以消费'
        count--;
        Chicken chicken = chickens[count];

//        吃完了， 通知生产者生产
        this.notifyAll();
        return chicken;

    }
}