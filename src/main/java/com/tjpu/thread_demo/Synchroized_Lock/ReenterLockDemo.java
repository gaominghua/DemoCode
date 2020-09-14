package com.tjpu.thread_demo.Synchroized_Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone =new Phone();
        System.out.println("==========================以下是测试synchronized可重入锁==========================");
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();
        TimeUnit.SECONDS.sleep(3);

        System.out.println("==========================以下是测试ReentenReentrantLock可重入锁==========================");

        new Thread(phone,"t3").start();
        new Thread(phone,"t4").start();
    }
}


//定义一个资源类，线程操作资源类
class Phone implements Runnable {
    //================================以下证明synchronized是重入锁====================================
    public synchronized void sendSMS() throws Exception{
        System.out.println("线程名："+Thread.currentThread().getName()+"线程ID："+Thread.currentThread().getId()+"执行sendSMS()----1----");
        sendEmail();
    }
    public synchronized void sendEmail() throws Exception{
        System.out.println("线程名："+Thread.currentThread().getName()+"线程ID："+Thread.currentThread().getId()+"执行sendEmail()--------2-------");
    }



    //================================以下证明ReenTrantLock是重入锁====================================

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
            get();
    }
    public void get() {
        lock.lock();
        try {
            System.out.println("线程名："+Thread.currentThread().getName()+"线程ID："+Thread.currentThread().getId()+"执行get()----1----");
            set();
        }finally {
            lock.unlock();
        }

    }
    public  void set(){
        lock.lock();
        try {
            System.out.println("线程名："+Thread.currentThread().getName()+"线程ID："+Thread.currentThread().getId()+"执行set()--------2-------");

        }finally {
            lock.unlock();
        }

    }


}

