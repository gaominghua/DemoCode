package com.tjpu.thread_demo.Produce_Consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 线程之间通信问题：生成者消费者问题。
 * 线程交替执行；A,B操作用以个变量num=0
 * //如何让线程有序执行？利用condition 精准唤醒线程参考代码Thread_lock_produce_consumer_2
 */

public class Thread_lock_produce_consumer_1 {
    public static void main(String[] args) {
        Data2 data2 =new Data2();

        new Thread(()->{ for (int i=0;i<10;i++) {
            try {
                data2.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"A1").start();

        new Thread(()->{ for (int i=0;i<10;i++) {
            try {
                data2.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"B1").start();
    }

}


//判断等待、业务、通知
//数字、资源类
class Data2{
    private  int number =0;
    Lock lock =new ReentrantLock();
    Condition condition = lock.newCondition();
    //+1操作
    public  void increment() throws InterruptedException {
            lock.lock();
        try{
            while (number!=0){
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"--->"+number);
            //通知其他线程+1，完毕
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    //-1操作
    public  void decrement() throws InterruptedException {

        lock.lock();
        try{
            while (number==0){
                //等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"--->"+number);
            //通知其他线程-1完毕
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}


