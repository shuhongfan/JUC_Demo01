package com.shf15Single;

//懒汉式单例
public class LazyMan {
    private static boolean shuhongfan = false;

    private LazyMan(){
        synchronized (LazyMan.class){
            if (shuhongfan==false){
                shuhongfan=true;
            } else {
                throw new RuntimeException("不要视图使用反射破坏异常");
            }
        }
    }

    private static LazyMan lazyMan;

//    双重检测锁模式及的  懒汉式单例 DCL懒汉式单例
    public static LazyMan getInstance(){
        if (lazyMan==null){
            synchronized(LazyMan.class){
                if (lazyMan==null){
                    lazyMan = new LazyMan();  // 不是一个原子性操作
                    /**
                     * 1.分配内存；空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     *
                     * 123
                     * 132
                     */
                }
            }
        }
        return lazyMan;  // 此时 lazyman还没有完成指令重排
    }


//    多线程并发
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LazyMan.getInstance();
            }).start();
        }
    }
}
