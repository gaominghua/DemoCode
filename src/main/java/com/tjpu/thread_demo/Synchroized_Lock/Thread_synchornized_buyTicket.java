package com.tjpu.thread_demo.Synchroized_Lock;

/**
 * 不安全的买票,线程不安全
 */

public class Thread_synchornized_buyTicket {
    public static void main(String[] args) {
        BuyTicket1 stataion = new BuyTicket1();

        new Thread(stataion,"用户1").start();
        new Thread(stataion,"用户2").start();
        new Thread(stataion,"用户3").start();

    }


}

class  BuyTicket1 implements Runnable{
    //票
    private int tickeNums =10;
    private boolean flag= true;//外部停止方式
    @Override
    public void run() {
        //买票
        while(flag){
            buy();
        }

    }
    //判断是否有票
    public  synchronized void buy(){
        if(tickeNums<=0){
            flag=false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到票："+tickeNums--);
    }
}
