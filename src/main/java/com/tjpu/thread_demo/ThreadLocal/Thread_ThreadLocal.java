package com.tjpu.thread_demo.ThreadLocal;

/**
 * 需求线程隔离：
 * 在多线程并发的场景下，每个线程中的变量都是相互独立的
 * 线程A:设置（变量1） 获取(变量1)
 * 线程B：设置(变量2)  获取(变量2)
 *     ThreadLocal:
 *              1.set():将变量绑定到当前线程
 *              2.get()：获取当前线程绑定的变量
 */
public class Thread_ThreadLocal {
}

/**
 * 以下案例通过ThreadLocal保证每个线程只获取自己线程内部的变量，每个线程都是彼此隔离的
 */
class Demo1{

    ThreadLocal<String> t1 =new ThreadLocal<>();

    //变量
    private String  content;
    private void setContent(String content){
        this .content=content;
        //变量content绑定到当前线程
        t1.set(content);
    }
    private String getContent(){
        String s=t1.get();
        return s;
    }

    public static void main(String[] args) {
        Demo1 demo1 =new Demo1();
        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                demo1.setContent(Thread.currentThread().getName()+"的数据");
                System.out.println("-------------------------------------");
                System.out.println(Thread.currentThread().getName()+"--->"+demo1.getContent());
            },"线程"+i).start();
        }
    }
}

/**
 * 线程运行的过程是抢占式，如果不用threadlocal的话那么无法保证每个线程是隔离的
 * 即：每个线程都有可能拿到其他线程内部的变量
 */
class Demo2{
    //变量
    private String  content;
    private void setContent(String content){
        this.content=content;
    }
    private String getContent(){
        return content;
    }

    public static void main(String[] args) {
        Demo2 demo2 =new Demo2();
        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                demo2.setContent(Thread.currentThread().getName()+"的数据");
                System.out.println("-------------------------------------");
                System.out.println(Thread.currentThread().getName()+"--->"+demo2.getContent());
            },"线程"+i).start();
        }
    }
}