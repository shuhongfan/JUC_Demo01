package com.shf.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 懒汉式
 */
public class LazyMan {

    private static boolean qinjiang = false;

    private LazyMan(){
        synchronized (LazyMan.class){
            if (qinjiang==false){
                qinjiang=true;
            } else{
                throw new RuntimeException("反射");
            }
        }
        System.out.println(Thread.currentThread().getName()+" ok");
    }

    private volatile static LazyMan lazyMan;

    public static LazyMan getInstance(){
//        加锁
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan=new LazyMan(); // 不是一个原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     */
                }
            }
        }
        return lazyMan;
    }

    //    单线程下确实单例ok
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LazyMan.getInstance();
            }).start();
        }

        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance2 = declaredConstructor.newInstance();

        System.out.println(instance);
        System.out.println(instance2);
    }
}
