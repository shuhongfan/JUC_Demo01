package com.shf5unfafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * hashSet底层是什么？ set本质是map，key是无法重复的
 * public HashSet() {
 *   map = new HashMap<>();
 * }
 *
 * // add方法
 * public boolean add(E e) {
 *   return map.put(e, PRESENT)==null;
 * }
 *
 * private static final Object PRESENT = new Object();
 *
 *
 */

/**
 * java.util.ConcurrentModificationException 并发修改异常
 * 1. Collections.synchronizedSet(new HashSet<String>());
 */
public class SetTest {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<String>());

        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
