package com.tjpu.thread_demo.JUCHelper;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/***
 * 同步队列，和其他BlockingQueue不一样，synchornousQueue不存储元素，
 * put了一个元素到队列里，必须等待取出来才能继续put
 */
public class Thread_JUC_SynchronousQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();//同步队列

        new Thread(()->{

            try {
                System.out.println(Thread.currentThread().getName()+"Put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"Put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"Put 3");
                blockingQueue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"取出了："+blockingQueue.take());
                System.out.println(Thread.currentThread().getName()+"取出了："+blockingQueue.take());
                System.out.println(Thread.currentThread().getName()+"取出了："+blockingQueue.take());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
