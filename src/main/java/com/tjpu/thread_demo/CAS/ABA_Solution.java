package com.tjpu.thread_demo.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题解决方案；采用时间戳作为版本号版本号
 */
public class ABA_Solution {
    static AtomicReference<Integer> atomicReference =new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampReference =new AtomicStampedReference<>(100,1);


    public static void main(String[] args) {
        System.out.println("====================以下是ABA问题得产生===========================================");
        new Thread(()->{
            atomicReference.compareAndSet(100,101);//如果期望值是100那么修改成101
            atomicReference.compareAndSet(101,100);//如果期望值是101那么修改成100

        },"线程1").start();

        new Thread(()->{
            //线程暂停1s
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2020)+"此时获得得值："+atomicReference.get());

        },"线程2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("====================以下是ABA问题得解决===========================================");


        new Thread(()->{
           //获取版本号
            int stamp = atomicStampReference.getStamp();
            System.out.println(Thread.currentThread().getName()+" 拿到得第一次版本号是："+stamp);
            //线程暂停3s线程3，
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //开始进行CAS
            atomicStampReference.compareAndSet(100,101,atomicStampReference.getStamp(),atomicStampReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+" 拿到得第二次版本号是："+atomicStampReference.getStamp());
            atomicStampReference.compareAndSet(101,100,atomicStampReference.getStamp(),atomicStampReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+" 拿到得第三次版本号是："+atomicStampReference.getStamp());
            },"线程3").start();

        new Thread(()->{
            //获取版本号
            int stamp = atomicStampReference.getStamp();
            System.out.println(Thread.currentThread().getName()+" 拿到得第一次版本号是："+stamp);
            //线程暂停3s线程4，
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampReference.compareAndSet(100, 2020, stamp, stamp + 1);

            System.out.println(Thread.currentThread().getName()+"是否修改成功："+result+"当前最新版本号："+atomicStampReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"当前实际最新值："+atomicStampReference.getReference());

        },"线程4").start();
    }
}
