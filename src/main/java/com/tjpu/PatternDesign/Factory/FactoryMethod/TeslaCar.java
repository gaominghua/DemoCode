package com.tjpu.PatternDesign.Factory.FactoryMethod;

public class TeslaCar implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
