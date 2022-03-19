package com.shf6add;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * public FutureTask(Callable<V> callable) {
 */
public class shf6CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread().start();

        MyThread thread = new MyThread();
//        适配类
        FutureTask futureTask = new FutureTask(thread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        Integer o = (Integer) futureTask.get();
        System.out.println(o);
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println("call()");
        return 1024;
    }
}
