package com.shf16cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo1 {
    public static void main(String[] args) {
//        AtomicStampedReference 注意，如果泛型是一个包装类，注意对象的引用问题
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp(); // 获得版本号
            System.out.println("a1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(
                    1,
                    2,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp()+1);
            System.out.println("a2=>"+stamp);

            atomicStampedReference.compareAndSet(
                    2,
                    1,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp()+1);
            System.out.println("a3=>"+stamp);
        },"a").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("b1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(
                    1,
                    6,
                    stamp,
                    stamp+1
                    );

        },"b").start();
    }
}
