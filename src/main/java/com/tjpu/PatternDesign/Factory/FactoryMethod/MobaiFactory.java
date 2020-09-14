package com.tjpu.PatternDesign.Factory.FactoryMethod;

public class MobaiFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new MoBaiCar();
    }
}
