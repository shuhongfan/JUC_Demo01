package com.shf18JUC.demo01;

import java.util.concurrent.Callable;

//线程创建方式三：实现callable接口
public class TestThread4 implements Callable<Boolean> {

    private String url;
    private String name;

    @Override
    public Boolean call() throws Exception {
        return null;
    }
}

/**
 * 线程的状态
 * new:  Thread t = new Thread() 线程对象一旦创建就进入到了新生状态
 * 就绪状态： 当调用start（）方法，线程立即进入就绪状态，但不意味着立即调度执行
 * 运行状态： CPU调度进入运行状态，线程才真正执行线程体的代码块
 * 阻塞状态：当调用sleep，wait或同步锁定时，线程进入阻塞状态，就是代码不往下执行，则色事件解除后，重新进入就绪状态，等待CPU调度执行
 * dead：线程中断或者结束，一旦进入死亡状态，就不能再次启动
 *
 *
 */
