package com.tjpu.thread_demo.ContainerUnSafe_Safe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UnSafeSetDemo {

    /**
     * 1.故障现象
     *      java.util.ConcurrentModificationException
     *
     * 2.导致原因
     *      并发争抢修改导致，可以参考花名册签名情况理解
     *      一个人正在写入，另外一个人，过来抢夺，导致数据不一致异常
     *
     * 3.解决方案
     *      1.Collections.synchronizedSet(new HashSet<String>());
     *      2.new  CopyOnWriteArraySet<>();
     *
     * 4.优化建议
     */
    public static void main(String[] args) {
        //HashSet线程不安全
        Set<String>  set = new HashSet<>();
        //解决方法一:为HashSet添加安全得辅助类
        //Set<String> set  = Collections.synchronizedSet(new HashSet<String>());

        //解决方法二:为HashSet添加安全得辅助类
        //Set<String> set  =new  CopyOnWriteArraySet<>();

        /**
         *写时复制原理：当往一个容器里面添加元素得时候，不直接往当前容器Object[]添加，而是先将当前容器
         * Object[]进行Copy,复制出一个新得Object[] newElements,然后向新得容器添加元素，添加完成之后
         * 再将原来容器得引用指向新得容器，通过setArray(neeElements)。这样得好处是可以多copyOnWrite容器进行并发
         * 得读，而不需要加锁。因为此时当前容器不会添加任何元素。所以copyOnwrite有着读写分离得思想。
         */
        for (int i=1;i<=10000;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
            },String.valueOf(i)).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前Set容器对象个数:"+set.size());
    }
}
