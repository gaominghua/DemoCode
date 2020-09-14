package com.tjpu.thread_demo.Thread_Runnable_Callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_Runable_Executor {

    public static void main(String[] args) {
        //1.创建服务，创建线程池
        //newFixedThreadPool，参数为线程池大小
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //2.执行服务
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());

        //3.关闭服务
        executorService.shutdown();

    }

}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
