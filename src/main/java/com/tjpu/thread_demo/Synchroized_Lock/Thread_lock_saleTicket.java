package com.tjpu.thread_demo.Synchroized_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_lock_saleTicket {
    public static void main(String[] args) {
        Ticket ticket2 =new Ticket();
       //线程A
        new Thread(()->{for (int i = 0; i < 30; i++) ticket2.sale();},"A").start();
        //线程B
        new Thread(()->{for (int i = 0; i < 30; i++) ticket2.sale();},"B").start();
        //线程C
        new Thread(()->{for (int i = 0; i < 40; i++) ticket2.sale();},"C").start();
    }

}

//资源类
class Ticket2 {
    //属性方法
    private int number = 100;

    Lock lock =new ReentrantLock();

    //本质：队列锁
    public   void sale(){

        lock.lock();//加锁
        lock.tryLock();//尝试获取锁
        try{
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票，剩余："+number);
            }
        }catch (Exception e){

        }finally {
            lock.unlock();//解锁
        }

    }
}
