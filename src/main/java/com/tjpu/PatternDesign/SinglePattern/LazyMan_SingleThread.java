package com.tjpu.PatternDesign.SinglePattern;

/**
 * 线程不安全的案例如下：
 */
class LazyMan2 {
    private LazyMan2(){
        System.out.println(Thread.currentThread().getName()+" OK");
    }
    private static LazyMan2 lazyMan2;

    public static LazyMan2 getInstance(){
        if (lazyMan2==null){
            lazyMan2=new LazyMan2();
        }
        return  lazyMan2;
    }

    //多线程并发,不安全，会由多个线程拿到对象，因此需要采用DCL检测代码参考LazyMan_DCl
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                lazyMan2.getInstance();
            }).start();
        }
    }
}
