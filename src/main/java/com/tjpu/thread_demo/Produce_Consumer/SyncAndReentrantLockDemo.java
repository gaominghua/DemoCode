package com.tjpu.thread_demo.Produce_Consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现精确唤醒：
 * 题目：
 *      AA打印5次，BB打印10次，CC打印15次  10轮操作
 *
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResouce shareResouce =new ShareResouce();
       new Thread(()->{
           for (int i = 0; i < 1; i++) {
               try {
                   shareResouce.print5();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       },"线程A").start();

        new Thread(()->{
            for (int i = 0; i < 1; i++) {
                try {
                    shareResouce.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程B").start();

        new Thread(()->{
            for (int i = 0; i < 1; i++) {
                try {
                    shareResouce.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程C").start();
    }
}

class ShareResouce{
    private int num=1;//A：1 B:2 C:3
    private Lock lock =new ReentrantLock();
    private Condition condition1 =lock.newCondition();//对应A
    private Condition condition2 =lock.newCondition();//对应B
    private Condition condition3 =lock.newCondition();//对应C

    public void print5() throws InterruptedException {
        lock.lock();
        try {
            //1.判断
            while(num!=1){
                condition1.await();//线程A阻塞
            }
            //打印5次
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+" i:"+i);
            }
            num=2;
            condition2.signal();//通知线程B
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        lock.lock();
        try {
            //1.判断
            while(num!=2){
                condition2.await();//线程B阻塞
            }
            //打印10次
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+" i:"+i);
            }
            num=3;
            condition3.signal();//通知线程C
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        lock.lock();
        try {
            //1.判断
            while(num!=3){
                condition3.await();//线程C阻塞
            }
            //打印15次
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+" i:"+i);
            }
            num=1;
            condition1.signal();//通知线程A
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}