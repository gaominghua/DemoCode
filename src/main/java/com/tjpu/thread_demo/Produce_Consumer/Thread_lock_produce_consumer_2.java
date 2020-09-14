package com.tjpu.thread_demo.Produce_Consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 线程之间通信问题：生成者消费者问题。
 * 线程交替执行；A,B操作用以个变量num=0
 * //利用condition 精准唤醒线程线程A->B->C->D
 */

public class Thread_lock_produce_consumer_2 {
    public static void main(String[] args) {
        DataPrint dataPrint =new DataPrint();

        new Thread(()->{ for (int i=0;i<10;i++) {
            try {
                dataPrint.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"A").start();

        new Thread(()->{ for (int i=0;i<10;i++) {
            try {
                dataPrint.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"B").start();

        new Thread(()->{ for (int i=0;i<10;i++) {
            try {
                dataPrint.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"C").start();

        new Thread(()->{ for (int i=0;i<10;i++) {
            try {
                dataPrint.printD();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"D").start();
    }

}


//判断等待、业务、通知
//数字、资源类
class DataPrint {
    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition4 = lock.newCondition();


    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                //等待
                condition1.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "--->AAAAAA");
            //通知其他线程+1，完毕
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while (number != 2) {
                //等待
                condition2.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "--->BBBBBB");
            //通知其他线程+1，完毕
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while (number != 3) {
                //等待
                condition3.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "--->CCCC");
            //通知其他线程+1，完毕
            number = 4;
            condition4.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printD() throws InterruptedException {
        lock.lock();
        try {
            while (number != 4) {
                //等待
                condition4.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "--->DDDD");
            //通知其他线程+1，完毕
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}


