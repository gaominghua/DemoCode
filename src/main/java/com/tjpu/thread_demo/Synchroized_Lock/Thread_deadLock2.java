package com.tjpu.thread_demo.Synchroized_Lock;

import java.util.concurrent.TimeUnit;

public class Thread_deadLock2 {
    public static void main(String[] args) {

        String lockA="lockA";
        String lockB="lockB";

        new Thread(new MyThread2(lockA,lockB),"T1").start();
        new Thread(new MyThread2(lockB,lockA),"T2").start();
    }
}

class MyThread2 implements Runnable{

    private String lockA;
    private String lockB;

    public MyThread2(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println("当前线程是："+Thread.currentThread().getName()+" lock:"+lockA+"===>get"+lockB);
            System.out.println("11111111111111111111");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println("当前线程是："+Thread.currentThread().getName()+"  lock:"+lockB+"===>get"+lockA);
                System.out.println("222222222222");
            }

        }
    }
}
