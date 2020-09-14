package com.tjpu.PatternDesign.Factory.FactoryMethod;

public class TeslaFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new TeslaCar();
    }
}
