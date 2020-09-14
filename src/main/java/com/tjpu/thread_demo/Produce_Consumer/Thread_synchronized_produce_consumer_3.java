package com.tjpu.thread_demo.Produce_Consumer;

/***
 * 线程之间通信问题：生成者消费者问题。
 * 线程交替执行；A,B操作用以个变量num=0
 */
public class Thread_synchronized_produce_consumer_3 {
    public static void main(String[] args) throws InterruptedException {
        Data data =new Data();

        new Thread(()->{ for (int i=0;i<10;i++) data.increment();},"A").start();

        new Thread(()->{ for (int i=0;i<10;i++) data.decrement();},"B").start();

//        new Thread(()->{ for (int i=0;i<10;i++) data.increment();},"C").start();
//
//        new Thread(()->{ for (int i=0;i<10;i++) data.decrement();},"D").start();
    }

}



//判断等待、业务、通知
//数字、资源类
class Data{
    private  int number =0;

    //+1
    public synchronized void increment(){
        while (number!=0){
            //等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"--->"+number);
        //通知其他线程+1，完毕
        this.notifyAll();
    }

    //-1
    public synchronized void decrement(){
        while (number==0){
            //等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"--->"+number);
        //通知其他线程-1完毕
        this.notifyAll();
    }

}


