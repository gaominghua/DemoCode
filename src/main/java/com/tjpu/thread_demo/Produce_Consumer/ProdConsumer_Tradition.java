package com.tjpu.thread_demo.Produce_Consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：
 * 生产消费：实现一个初始值为0的变量，两个线程对其交替操作，一个加1一个减1，执行5次
 * 步骤1. 线程操作资源类
 *     2.判断 干活 通知
 *
 */
public class ProdConsumer_Tradition {


    public static void main(String[] args) {
        ShareData shareData =new ShareData();
        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"生产线程"+String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"消费线程"+String.valueOf(i)).start();
        }

    }
}


class ShareData{
    private int number=0;
    private Lock lock =new ReentrantLock();
    Condition condition=lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number!=0){
                //等待不能生产
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"number:"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number==0){
                //等待不能生产
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"number:"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
