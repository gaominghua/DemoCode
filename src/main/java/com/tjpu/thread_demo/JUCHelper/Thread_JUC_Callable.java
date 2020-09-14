package com.tjpu.thread_demo.JUCHelper;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread_JUC_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Mythread mythread =new Mythread();
        FutureTask futureTask = new FutureTask(mythread);//适配，中介
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();//同样的结果只会打印一次，被缓存效率高

        Integer o = (Integer) futureTask.get();//方法可能会产生阻塞，需要放到最后，也可使用异步通信处理
        System.out.println(o);

    }

}



class  Mythread implements Callable<Integer> {

    public Integer call(){
        System.out.println("打印--------call");
        return 1024;
    }
}