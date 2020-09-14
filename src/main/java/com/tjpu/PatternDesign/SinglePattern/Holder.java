package com.tjpu.PatternDesign.SinglePattern;

/**
 * 单例模式的静态内部类
 */
public class Holder {
    private Holder(){}

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    //以下是一个静态内部类
    public static class InnerClass{
        private static final  Holder HOLDER=new Holder();
    }
}
