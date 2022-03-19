package com.shf5unfafe;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
//        map是这样用的吗？不是,工作中不用HashMap
//        默认等价于什么？
//        HashMap<String, String> map = new HashMap<>(16,075);
//      加载因子 DEFAULT_LOAD_FACTOR = 0.75f;,初始化容量static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

//        HashMap<String, String> map = new HashMap<>();

        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
