package com.shf.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread); // 适配类

        new Thread(futureTask,"A").start();

        Integer o = (Integer) futureTask.get();  // 获取Callable的返回结果
        System.out.println(o);
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("public String call()");
        return "1024";
    }
}
