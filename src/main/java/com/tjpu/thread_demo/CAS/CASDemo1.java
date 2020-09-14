package com.tjpu.thread_demo.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:比较当前得值是否是期望得，如果是那么跟新不是那么不操作一致循环
 */
public class CASDemo1 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger =new AtomicInteger(5);

        //1.如果是期望得是5、那么将其更新成2019
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"当前值是："+atomicInteger.get());

        //2.由于1步骤修改成了2019所以，此时期望得值修改不成功，值还是2019
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"当前值是："+atomicInteger.get());

    }
}
