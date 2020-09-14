package com.tjpu.thread_demo.Synchroized_Lock.DIYReentrantLock;

import java.util.concurrent.TimeUnit;

public class TestDIYLock {
    public static void main(String[] args) throws InterruptedException {
        DIYReentrantLock lock =new DIYReentrantLock();
        new Thread(()->{
            lock.lock();
            System.out.println("持有锁线程01.......");
            lock.unlock();
        },"线程1").start();

        TimeUnit.SECONDS.sleep(1);

//        new Thread(()->{
//            lock.lock();
//            System.out.println("持有锁线程02.......");
//            lock.unlock();
//        },"线程2").start();
    }
}
