package com.tjpu.thread_demo.Volatile;

import java.util.concurrent.TimeUnit;

/***
 * volatile保证了可见性
 */
public class Volatile_JMM_demo1 {
    //private static int num=0;//不加volatile，此时线程一内存中读取得值num 一直是0
    private  volatile  static int num=0;//加volatile，此时线程一内存中读取得值num是1，保证了可见性

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{//线程1---只有加了volatile得情况下才能感知主内存中得num被修改
            while (num==0){

            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        num=1;
        System.out.println(num);
    }
}
