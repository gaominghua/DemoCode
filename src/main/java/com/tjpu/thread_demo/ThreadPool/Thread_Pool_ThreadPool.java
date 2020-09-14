package com.tjpu.thread_demo.ThreadPool;

import java.util.concurrent.*;

public class Thread_Pool_ThreadPool {

    public static void main(String[] args) {
        //自定义线程池
        //最大线程池该如何定义？
        //1.CPU密集型: 几核CPU可以有多少条线程同时进行，几核就定义几，此时效率最高
        //2.IO密集型:  判断你的程序中十分消耗IO的线程
        // 一个程序 15个大型任务 IO十分占用资源 通常可以设置成2倍 即最大2*15=30个线程

        //动态获取CPU内核数目
        System.out.println("本机CPU核心数："+Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool =new ThreadPoolExecutor(
                2,
                //Runtime.getRuntime().availableProcessors(),//物理机器的CPU内核数目
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());//策略的意思---队列满了如果还有元素进入则不处理
//                 new ThreadPoolExecutor.CallerRunsPolicy());//策略的意思---哪里来的去哪里，回到main线程
//                 new ThreadPoolExecutor.DiscardPolicy());//策略的意思---处理线程，队列满了不会抛出异常
                new ThreadPoolExecutor.AbortPolicy());//策略的意思---处理线程，队列满了尝试和最早的线程竞争



        try {
            for (int i = 1; i <=10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" OK");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //线程池用完需要关闭线程池
            threadPool.shutdown();
        }

    }
}
