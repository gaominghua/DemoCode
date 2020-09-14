package com.tjpu.PatternDesign.Factory.FactoryMethod;

public class WulingFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new WuLingCar();
    }
}
