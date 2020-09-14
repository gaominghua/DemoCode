package com.tjpu.thread_demo.Produce_Consumer;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile/CAS/atomicInteger/BlockQueue
 */
public class ProdConsumer_BlockQueue {
    public static void main(String[] args) throws InterruptedException {
        MyResouce myResouce =new MyResouce(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            try {
                myResouce.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"生产者").start();

        new Thread(()->{
            try {
                myResouce.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"消费者").start();

        TimeUnit.SECONDS.sleep(5);
        System.out.println("===================5秒中到了=============停止生产==========");
        myResouce.stop();
    }
}

//线程资源类
class MyResouce{
    private volatile boolean FLAG=true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue =null;

    public MyResouce(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    public void myProd() throws Exception{
        String data = null;
        Boolean retValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName()+"插入队列："+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"插入队列："+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"叫停了，表示Flag=flase，生产动作结束======");

    }
    public void myConsumer() throws Exception{
        String res =null;
        while (FLAG){
            res = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if (res==null||res.equals("")){
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"超过了2秒中没有取到数据，消费退出！=======");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"消费队列："+res+"成功");
        }
    }
    public void stop(){
        this.FLAG=false;
    }
}
