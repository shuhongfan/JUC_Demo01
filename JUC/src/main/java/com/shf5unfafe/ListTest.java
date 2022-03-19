package com.shf5unfafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//Exception in thread "3" java.util.ConcurrentModificationException 并发修改异常
public class ListTest {
    public static void main(String[] args) {
//        并发下 ArrayLisy 不安全
//        List<String> list = new ArrayList<>();

//        解决方案一 Vector不推荐：
//        List<String> list = new Vector<>();

//        解决方案二： Collections.synchronizedList(new ArrayList<String>());
//        List<String> list = Collections.synchronizedList(new ArrayList<String>());

//        解决方案三：new CopyOnWriteArrayList<>();  写入时复制 COW 计算机程序设计领域的一种优化策略
//        多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
//        在写入的时候避免覆盖，造成数据问题！
//        读写分离

//        CopyOnWriteArrayList 比 Vector 好在哪里？
//        Vector 使用synchronized效率低，CopyOnWriteArrayList使用lock锁保证线程安全
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
