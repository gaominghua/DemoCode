package com.tjpu.thread_demo.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁的案例
 *   好处：不需要阻塞
 *   坏处：性能消耗太大
 */
public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference =new AtomicReference<>();

    public void myLock(){
        Thread thread =Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"进入-执行加锁==========");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void unLock(){
        Thread thread =Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"退出-执行解锁==========");
        atomicReference.compareAndSet(thread,null);
    }
    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLock =new SpinLockDemo();

        new Thread(()->{
            spinLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           spinLock.unLock();
        },"线程A").start();
        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{

            spinLock.myLock();
            spinLock.unLock();
        },"线程B").start();

    }
}
