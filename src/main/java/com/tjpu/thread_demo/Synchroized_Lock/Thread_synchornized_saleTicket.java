package com.tjpu.thread_demo.Synchroized_Lock;

public class Thread_synchornized_saleTicket {
    public static void main(String[] args) {
        Ticket ticket =new Ticket();
       //线程A
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }

        },"A").start();
        //线程B
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }

        },"B").start();
        //线程C
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }

        },"C").start();
    }

}

//资源类
class Ticket {
    //属性方法
    private int number = 100;

    //本质：队列锁
    public  synchronized void sale(){
        if (number>0){
            System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票，剩余："+number);
        }
    }
}
