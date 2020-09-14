package com.tjpu.PatternDesign.SinglePattern;

/***
 * 饿汉式单例模式:一上来就加载对象
 */
class Hungry {
    //可能会浪费空间，一上来就会创建这4个对象，因为构造方法new了hungry对象会加载下面的代码
    private byte[] data1= new byte[1024*1024];
    private byte[] data2= new byte[1024*1024];
    private byte[] data3= new byte[1024*1024];
    private byte[] data4= new byte[1024*1024];

    private Hungry(){

    }
    private final static Hungry
            Hungry = new Hungry();//一上来构造方法就new一个对象

    private static  Hungry getInstance(){

        return Hungry;
    }

}
