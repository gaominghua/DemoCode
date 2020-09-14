package com.tjpu.PatternDesign.Builder.Demo1;

/**
 * 指挥：负责指挥构建一个工程，工程如何构建由它决定
 */
public class Director {
    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();

        return  builder.getProduct();

    }
}
