package com.tjpu.thread_demo.JUCHelper;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Thread_JUC_Semaphore {

    public static void main(String[] args) {

        //线程数量：停车位
        Semaphore semaphore =new Semaphore(2);

        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                try {
                    //acquire，获得
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }
    }
}
