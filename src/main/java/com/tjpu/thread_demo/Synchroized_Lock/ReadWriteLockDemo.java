package com.tjpu.thread_demo.Synchroized_Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类没有问题,为了满足并发量，读取共享资源可以同时进行
 * 但是
 * 如果有一个线程想去写共享资源，就不应该再有其他线程可以对该资源进行读或者写
 * 总结：
 *      读----读   可以
 *      读----写  不可以
 *      写----写   不可以
 *
 *      写：原子+独占
 */

//线程操作资源类
class MyCache1{
    private volatile Map<String,Object>  map = new HashMap<>();
    private ReentrantReadWriteLock rwLock =new ReentrantReadWriteLock();

    public void put(String key,Object value) throws InterruptedException {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 正在写入:"+key);

            TimeUnit.MICROSECONDS.sleep(300);//模拟网络拥堵

            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" 写入完成!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }

    }

    public void get(String key) throws InterruptedException {

        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 正在读取!!!");

            TimeUnit.MICROSECONDS.sleep(300);//模拟网络拥堵

            Object res = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 读取完成："+res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }
}


public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache1 myCache =new MyCache1();
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                try {
                    myCache.put(tempInt+"",tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"线程"+String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                try {
                    myCache.get(tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"线程"+String.valueOf(i)).start();
        }
    }

}


