package com.tjpu.thread_demo.ThreadPool;


import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Executors工具类、3大方法
//使用了线程池，需要使用线程池来创建线程
public class Thread_Pool_Executors {
    public static void main(String[] args) {

        ExecutorService threadPool1 =  Executors.newSingleThreadExecutor();//单个线程
        ExecutorService threadPool2 =  Executors.newFixedThreadPool(5); //创建一个固定线程池大小
        ExecutorService threadPool3 =  Executors.newCachedThreadPool();//创建可伸缩的线程池

        //模拟10个用户来办理业务，每个用户就是一个来自外部请求的线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 办理业务OK");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //线程池用完需要关闭线程池
            threadPool1.shutdown();
        }



    }
}
