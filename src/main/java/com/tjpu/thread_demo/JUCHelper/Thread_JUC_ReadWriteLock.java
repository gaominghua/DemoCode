package com.tjpu.thread_demo.JUCHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/***
 * ReadWriteLock 读写锁
 */
public class Thread_JUC_ReadWriteLock {

    public static void main(String[] args) {
        MyCacheLock myCache =new MyCacheLock();
        //写入
        for (int i = 1; i <= 10; i++) {
            final  int temp=i;
            new Thread(()->{myCache.put(temp+"",temp+"");},String.valueOf(i)).start();
        }

        //读取
        for (int i = 1; i <= 10; i++) {
            final  int temp=i;
            new Thread(()->{myCache.get(temp+"");},String.valueOf(i)).start();
        }
    }

}

//自定义缓存---未枷锁
class MyCache{


    private volatile Map<String,Object> map= new HashMap<>();


    //存----写
    public void put(String key ,Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入OK");
    }

    //取----读
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取Ok");
    }

}
//枷锁的类
class MyCacheLock{


    private volatile Map<String,Object> map= new HashMap<>();

    //读写锁，更加细粒度的控制
    private  ReentrantReadWriteLock readWriteLock =  new ReentrantReadWriteLock();


    //存----写----写入的时候只希望只有一个线程写
    public void put(String key ,Object value){

        try {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"写入OK");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }


    }

    //取----读----读的时候可以有多个线程读
    public void get(String key){
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o = map.get(key);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"读取Ok");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }

    }

}