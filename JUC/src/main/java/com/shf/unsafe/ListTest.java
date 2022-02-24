package com.shf.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());

//        CopyOnWriteArrayList 写入时复制    COW计算机程序设计领域的一种优化策略
//        多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）

        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
