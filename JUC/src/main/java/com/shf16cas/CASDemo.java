package com.shf16cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS compareAndSet：比较并交换，比较当前工作内存中的值和主内存中的，
 *                   如果这个值是期望的，那么执行更新操作！如果不是一般一直循环！
 * java无法操作内存，Java可以调用C++  native，C++可以操作内存
 * unsafe相当于java的后门，可以通过unsafe操作内存
 * private static final Unsafe unsafe = Unsafe.getUnsafe();
 *
 *  CAS 缺点
 *  1. 循环会耗时
 *  2.一次只能保证一个共享变量的原子性
 *  3.ABA问题
 *
 * CAS： ABA问题（狸猫换太子）
 * 解决ABA问题，引入源自引用！ 对应的思想：乐观锁问题
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

//        对于我们平时写的SQL： 乐观锁

//        如果我的期望值达到了，那么就更新，否则，就不更新  CAS是CPU的并发源语
//        public final boolean compareAndSet(int expect, int update) {
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2020, 6666));
        System.out.println(atomicInteger.get());

        atomicInteger.incrementAndGet();
    }
}

/**
 * public final int incrementAndGet() {
 *         return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
 *     }
 *
 * public final int getAndAddInt(Object var1, long var2, int var4) {
 *         int var5;
 *         do {  // 自旋锁
 *             var5 = this.getIntVolatile(var1, var2);  // 获取内存地址中的值
 *         } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4)); // 内存操作，效率很高
 *
 *         return var5;
 *     }
 */