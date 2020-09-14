package com.tjpu.thread_demo.Synchroized_Lock;


import java.util.concurrent.locks.ReentrantLock;

//测试Lock锁
public class Thread_lock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
    }

}


class TestLock2 implements Runnable{

    //票
    int tickNums=10;

    //定义lock锁
    private final ReentrantLock lock =new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try{
                lock.lock();//加锁
                if (tickNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tickNums--);
                }else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }


        }
    }
}
