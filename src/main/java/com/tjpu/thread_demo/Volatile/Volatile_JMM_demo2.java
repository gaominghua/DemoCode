package com.tjpu.thread_demo.Volatile;

import java.util.concurrent.atomic.AtomicInteger;

/***
 * volatile不保证了原子性，如果保证原子性则需要除了加synchornized、lock、还有其他方式！
 */
public class Volatile_JMM_demo2 {

   // private volatile static int num=0; //volatile不保证了原子性加了之后不保证原子性，
   private volatile static AtomicInteger num= new AtomicInteger(); //原子类，CAS


    public  static void add(){
//        num++;
        num.getAndIncrement();//AtomicInteger +1方法
    }
    public static void main(String[] args) {


        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j= 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
