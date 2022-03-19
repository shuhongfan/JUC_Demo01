package com.shf17lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁、非公平锁
 * 公平锁：非常公平，不能够插队，必须先来后到
 * 非公平锁：非常不公平，可以插队（默认都是非公平）
 */
public class Demo01 {
    Lock lock =  new ReentrantLock(true);
}

/**
 * public ReentrantLock() {
 *         sync = new NonfairSync();
 *     }
 *
 * public ReentrantLock(boolean fair) {
 *         sync = fair ? new FairSync() : new NonfairSync();
 *     }
 */