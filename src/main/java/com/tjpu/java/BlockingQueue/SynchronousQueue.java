package com.tjpu.java.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new java.util.concurrent.SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() +"\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() +"\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() +"\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() +"\t take 1");
                blockingQueue.take();
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() +"\t take 2");
                blockingQueue.take();
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() +"\t take 3");
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
