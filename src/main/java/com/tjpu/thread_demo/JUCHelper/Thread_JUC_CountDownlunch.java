package com.tjpu.thread_demo.JUCHelper;

import java.util.concurrent.CountDownLatch;

public class Thread_JUC_CountDownlunch {

    /**
     * 1.countDownLatch这个类使一个线程等待其他线程各自执行完毕后再执行。
     * 2.countDownLatch是通过一个计数器来实现的，计数器的初始值是线程的数量。
     * 每当一个线程执行完毕后，计数器的值就-1，当计数器的值为0时，表示所有线程都执行完毕，
     * 然后在闭锁上等待的线程就可以恢复工作了
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);
//        countDownLatch.countDown();//-1操作
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go Out!");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零，然后向下执行
        System.out.println("Close Door");
    }
}
