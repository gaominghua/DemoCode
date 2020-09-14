package com.tjpu.thread_demo.JUCHelper;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Thread_JUC_CyclicBarrier {

    public static void main(String[] args) {
        //集齐七颗龙珠召唤龙珠

        //召唤龙珠线程
        CyclicBarrier cyclicBarrier =new CyclicBarrier(7,()->{
            System.out.println("召唤神龙成功!");
        });

        for (int i = 0; i < 7; i++) {
            //lambda如何拿到i？需要定义final
            final  int temp =i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集了"+temp+"个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();

        }
    }

}
