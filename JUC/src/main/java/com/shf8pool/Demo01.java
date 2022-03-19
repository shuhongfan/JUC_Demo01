package com.shf8pool;

import java.util.concurrent.*;

//Executors 工具类、3大方法、7大参数、4种拒绝策略
//使用了线程池之后
public class Demo01 {
    public static void main(String[] args) {
//        3大方法
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5); //创建一个固定的线程池的大小
//        ExecutorService threadPool = Executors.newCachedThreadPool(); // 可伸缩，遇强则强，遇弱则弱

//        自定义线程池 ThreadPoolExecutor
//        最大承载： Deque+max

//        最大线程到底该如何定义：
//        1. CPU密集型、几核、就是几、可以保持CPU的效率最高
//        2.IO密集型》判断你程序中十分耗IO的线程
//        程序  15个大型任务  io十分占用资源

//        获取CPU的核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,  //  核心线程池大小
                5,  // 最大核心线程池大小
                3,  // 超时时间
                TimeUnit.SECONDS,  // 超时单位
                new LinkedBlockingDeque<>(3),  // 阻塞队列
                Executors.defaultThreadFactory(),  // 线程工程，创建线程的，一般不用动
                                                            // 4大拒绝策略
//                new ThreadPoolExecutor.AbortPolicy() // 银行满了，还有人进来，不处理这个人的，抛出异常
//                new ThreadPoolExecutor.CallerRunsPolicy() // 哪里来的去哪里
//                new ThreadPoolExecutor.CallerRunsPolicy() // 哪里来的去哪里
//                new ThreadPoolExecutor.DiscardPolicy() // 队列满了，丢掉任务，不会抛出异常
                new ThreadPoolExecutor.DiscardOldestPolicy() // 队列满了，尝试取和最早的竞争，也不会抛出异常
        );

        for (int i = 1; i <= 10; i++) {
//            使用线程池之后，使用线程池来创建线程
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() +" ok");
            });
        }

//        线程池用完，程序结束，关闭线程池
        threadPool.shutdown();
    }
}


/**
 * 池化技术
 * 程序的运行，本质：占用系统的资源！ 优化资源的使用！ ====》池化技术
 * 线程池、连接池、内存值、对象池.....
 * 池化技术：事先准保好一些资源，有人要用，就来我这里拿，用完之后还给我
 *
 * 线程池的好处：
 * 1.降低资源的消耗
 * 2.提高相应速度
 * 3.方便管理
 *
 * public static ExecutorService newSingleThreadExecutor() {
 *         return new FinalizableDelegatedExecutorService
 *             (new ThreadPoolExecutor(1, 1,  // 核心线程大小1；最大核心线程1；
 *                                     0L, TimeUnit.MILLISECONDS,
 *                                     new LinkedBlockingQueue<Runnable>()));
 *     }
 *
 * public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
 *         return new ThreadPoolExecutor(nThreads, nThreads,  // 核心线程大小5；最大核心线程5；
 *                                       0L, TimeUnit.MILLISECONDS,
 *                                       new LinkedBlockingQueue<Runnable>(),
 *                                       threadFactory);
 *     }
 *
 * public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
 *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,  // 核心线程大小0，最大核心线程21亿
 *                                       60L, TimeUnit.SECONDS,
 *                                       new SynchronousQueue<Runnable>(),
 *                                       threadFactory);
 *     }
 *
 * public ThreadPoolExecutor(int corePoolSize,  //  核心线程池大小
 *                               int maximumPoolSize,  // 最大核心线程池大小
 *                               long keepAliveTime, // 超时了没有人调用就会释放
 *                               TimeUnit unit,  // 超时单位
 *                               BlockingQueue<Runnable> workQueue, // 阻塞队列
 *                               ThreadFactory threadFactory,  // 线程工程，创建线程的，一般不用动
 *                               RejectedExecutionHandler handler) {  // 拒绝策略
 *         if (corePoolSize < 0 ||
 *             maximumPoolSize <= 0 ||
 *             maximumPoolSize < corePoolSize ||
 *             keepAliveTime < 0)
 *             throw new IllegalArgumentException();
 *         if (workQueue == null || threadFactory == null || handler == null)
 *             throw new NullPointerException();
 *         this.acc = System.getSecurityManager() == null ?
 *                 null :
 *                 AccessController.getContext();
 *         this.corePoolSize = corePoolSize;
 *         this.maximumPoolSize = maximumPoolSize;
 *         this.workQueue = workQueue;
 *         this.keepAliveTime = unit.toNanos(keepAliveTime);
 *         this.threadFactory = threadFactory;
 *         this.handler = handler;
 *     }
 */