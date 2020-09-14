package com.tjpu.thread_demo.Volatile;


import java.util.concurrent.TimeUnit;

/**
 * 验证volatile可见性
 * 1.假如int number=0；num变量之前根本没有加volatile关键字
 */
public class VolatileDemo1 {
    public static void main(String[] args) {
        MyData myData = new MyData();//线程操作资源类
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"进入---------");

            try {
                TimeUnit.SECONDS.sleep(3);//线程A睡眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();  //将值修改成60；
            System.out.println(Thread.currentThread().getName()+"将number更新成了60---------");
        },"线程A").start();

        while (myData.number==0){
            //main线程一致等待循环直到number不在等于0
        }
        System.out.println(Thread.currentThread().getName()+"线程感知道number值发生变化---");
    }
}

class MyData{
    //int  number =0;//number未使用volatile,Main无法感知number发生改变
    volatile int  number =0;
    public void addTo60(){
        this.number=60;
    }
}