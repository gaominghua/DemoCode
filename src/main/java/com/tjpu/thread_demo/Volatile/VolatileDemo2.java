package com.tjpu.thread_demo.Volatile;

import java.util.concurrent.TimeUnit;

/**
 * 验证volatile的原子性
 * 什么是原子性：
 *      某个线程再执行某个具体业务的时候中间不可以被加塞或者被分割、要么同时成功要么同时失败
 */
public class VolatileDemo2 {
    public static void main(String[] args) {
        MyData2 myData2 =new MyData2();
        for (int i = 1; i <= 2; i++) {
            new Thread(()->{
                for (int j= 1; j <= 1000; j++) {
                    myData2.addPlusPlus();
                }
            },"线程"+String.valueOf(i)).start();
        }
        //需要等待20个线程全部计算完之后，再用Main线程查看number的值
        while (Thread.activeCount()>2){ //默认后台Main线程+GC线程，如果20个线程结束那么只有2个线程存在
            Thread.yield();//礼让等待20个线程结束
        }
        System.out.println(Thread.currentThread().getName()+"最终结果Number值："+myData2.number);
    }

}
class MyData2{
    //int  number =0;//number未使用volatile,Main无法感知number发生改变
    volatile int  number =0;
    //此时number++，number加了volatile不保证原子性
    public void addPlusPlus(){
       number++;
       //number++底层分为三个操作
            //1.执行getfield拿到原始的number
            //2.执行iadd指令进行+1操作
            //3.执行putfield写把累加后的值写回
    }
}