package com.tjpu.thread_demo.JUCHelper;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 一道面试题：实现一个容器，提供两个方法，add,size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，
 * 当个数到5个时，线程2给出提示并结束
 *
 * CountDownLatch
 * 使用await和countdown方法替代wait和notify
 * CountDownLatch不涉及锁定，当count的值为零时当前线程继续运行
 * 相当于是发令枪，运动员线程调用await等待，计数到0开始运行
 * 当不涉及同步，只是涉及线程通信的时候，用synchronized加wait，notify就显得太重了
 * */
public class CounDownLatchDemo1 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch =new CountDownLatch(5);
        Container1 container1 =new Container1();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                container1.add(i);
                System.out.println("container add："+i);
                countDownLatch.countDown();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程1").start();

        new Thread(()->{
            try {
                    countDownLatch.await();
                    System.out.println("线程2提示----结束========");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ;
        },"线程2").start();

    }
}

class Container1 {

    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }
}