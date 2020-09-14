package com.tjpu.thread_demo.JUCHelper;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Thread_JUC_BlockingQueue {

    public static void main(String[] args) {

        //Collection父类
        //List，set，BlockingQueue 同级别，不是新的东西
        //什么情况下会使用阻塞队列？？？---->多线程并发处理，线程池
        test1();

    }
    /**
     * 抛出异常
     */
    public static void  test1(){
        //参数--队列大小
        ArrayBlockingQueue arrayBlockingQueue =new ArrayBlockingQueue(3);
        //查看队首的元素值,会抛出异常
        System.out.println(arrayBlockingQueue.element());

        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
        //再添加一个队列满了抛出异常
        //System.out.println(arrayBlockingQueue.add(""));

        //取出来队列的元素
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());

        //再取出一个队列元素后为空了抛出异常
        //System.out.println(arrayBlockingQueue.remove(""));

    }

    /***
     * 有返回值没有异常出现
     */
    public static void  test2(){
        //参数--队列大小
        ArrayBlockingQueue arrayBlockingQueue =new ArrayBlockingQueue(3);
        //查看队首的元素值,不会会抛出异常
        System.out.println(arrayBlockingQueue.peek());
        //写入队列
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        //队列满了之后不抛出异常
        //arrayBlockingQueue.offer("d");

        //取出元素
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());

        //队列空了之后不抛出异常
        //arrayBlockingQueue.poll();
    }

    /***
     * 等待阻塞（一直阻塞）
     */
    public static void  test3() throws InterruptedException {
        //参数--队列大小
        ArrayBlockingQueue arrayBlockingQueue =new ArrayBlockingQueue(3);
        //一直阻塞
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");

        //再添加一个d，由于队列没有位置会一直等待
        //arrayBlockingQueue.put("d");

        //取出队列元素
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        //如果队列为空，会一直等待取元素
        //System.out.println(arrayBlockingQueue.take());

    }

    /***
     * 等待超时
     */
    public static void  test4() throws InterruptedException {
        //参数--队列大小
        ArrayBlockingQueue arrayBlockingQueue =new ArrayBlockingQueue(3);
        //一直阻塞
        arrayBlockingQueue.offer("a");
        arrayBlockingQueue.offer("b");
        arrayBlockingQueue.offer("c");

        //再添加一个d，由于队列没有位置会一直等待2秒后退出
       // arrayBlockingQueue.offer("d",2, TimeUnit.SECONDS);

        //取出队列元素
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        //如果队列为空，会一直等待取元素
        //System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));

    }

}
