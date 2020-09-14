package com.tjpu.thread_demo.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CAS_demo {

    //CAS         atomicInteger.compareAndSet 比较并交换
    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger(2020);
//        atomicInteger.getAndIncrement();
        //atomicStampedReference 如果泛型是包装类需要注意对象的引用问题
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1,1);

        //对于我们平时写的SQL而言：乐观锁
        //   compareAndSet(int expect 期望, int update 更新)
        //如果我期望的值达到则跟新，否则不更新
        //CAS 是CPU的并发原语

        //======捣乱的线程======
//        System.out.println(atomicInteger.compareAndSet(2020, 2021));
//        System.out.println(atomicInteger.get());
//
//        System.out.println(atomicInteger.compareAndSet(2021, 2020));
//        System.out.println(atomicInteger.get());
//        //======期望的线程======
//        System.out.println(atomicInteger.compareAndSet(2020, 6666));
//        System.out.println(atomicInteger.get());

        //模拟俩个线程操作
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();//获得版本号
            System.out.println("a1===>"+stamp);

//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //version +1
            System.out.println(atomicStampedReference.compareAndSet(1,
                    2,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1));
            System.out.println("a2===>"+atomicStampedReference.getStamp());

            System.out.println(atomicStampedReference.compareAndSet(2,
                    1,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1));

            System.out.println("a3===>"+atomicStampedReference.getStamp());

        },"a").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();//获得版本号
            System.out.println("b1===>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(1,
                    6,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1));
            System.out.println("b1===>"+atomicStampedReference.getStamp());

        },"b").start();

    }



}
