package com.tjpu.thread_demo.JUCHelper;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/***
 * 异步调用：
 * //成功回调
 * //失败回调
 */
public class CompletableFuture_demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //发起一个请求，没有返回值的runAnsy异步回调
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"RunAsync=====>Void");
//        });
//        System.out.println("1111111");
//        completableFuture.get();//阻塞获取执行结果

        //发起一个请求，有返回值的supplyAnsy异步回调
        //ajax 成功和失败的回调
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync===>Void");
            try {
                TimeUnit.SECONDS.sleep(10);//模拟10s停顿
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i=10/0;
            return 1024;
        });
        System.out.println("主线程做其他事======================");
        completableFuture.whenComplete((t,u)->{
            System.out.println("t====>"+t);//t,正常的返回结果
            System.out.println("u====>"+u);//u,错误的信息
        }).exceptionally((e)->{
            e.getMessage();
            return 233;//可以获取到错误的返回结果
        }).get();

    }
}
