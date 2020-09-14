package com.tjpu.thread_demo.JUCHelper;

public class Thread_Yield {


    public static void main(String[] args) {
        MyYield myYield =new MyYield();

        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();

    }

    public static class MyYield implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"线程开始执行------");
            Thread.yield();
            System.out.println(Thread.currentThread().getName()+"线程停止执行------");
        }
    }
}
