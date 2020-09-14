package com.tjpu.thread_demo.ContainerUnSafe_Safe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UnSafeMapDemo {

    /**
     * 1.故障现象
     *      java.util.ConcurrentModificationException
     *
     * 2.导致原因
     *      并发争抢修改导致，可以参考花名册签名情况理解
     *      一个人正在写入，另外一个人，过来抢夺，导致数据不一致异常
     *
     * 3.解决方案
     *      1.new ConcurrentHashMap<>();
     *
     * 4.优化建议
     */
    public static void main(String[] args) {
        //HasMap线程不安全
        //Map<String,String> map = new HashMap<>();
        //解决方法一:使用new ConcurrentHashMap<>();
        Map<String,String> map =new ConcurrentHashMap<>();

        for (int i=1;i<=10000;i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                //System.out.println(map);
            },String.valueOf(i)).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前Map容器对象个数:"+map.size());
    }
}
