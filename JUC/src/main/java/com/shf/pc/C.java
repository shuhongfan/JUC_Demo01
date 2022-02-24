package com.shf.pc;

import javax.xml.crypto.Data;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C {
    public static void main(String[] args) {
        Data3 data = new Data3();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        }, "C").start();
    }
}

class Data3 {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int number = 1;

    public void printA() {
        lock.lock();
        try {
            while (number!=1){
    //            等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+" => AAA");
//        唤醒，唤醒指定的人，B
            number=2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (number!=2){
                //            等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+" => BBB");
//        唤醒，唤醒指定的人，C
            number=3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (number!=3){
                //            等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+" => CCC");
//        唤醒，唤醒指定的人，B
            number=1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
