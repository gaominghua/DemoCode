package com.tjpu.PatternDesign.Builder.Demo1;

/**
 * 抽象的建造者，只定义一些方法
 */
public abstract  class Builder {
    abstract void buildA();//1.地基工程
    abstract void buildB();//2.钢筋工程
    abstract void buildC();//3.铺电线工程
    abstract void buildD();//4.粉刷工程

    abstract Product getProduct();//得到产品
}
