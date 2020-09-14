package com.tjpu.PatternDesign.Factory.FactoryMethod;




public class Consumer {
    public static void main(String[] args) {

        Car car1 =new WulingFactory().getCar();
        Car car2 = new TeslaFactory().getCar();
        car1.name();
        car2.name();

        //如果需要再添加一个车呢？可以新添加一个车的工厂例如Mobai车、
        Car car3 =new MobaiFactory().getCar();
        car3.name();

        //以上实现了扩展，不需要修改Car工厂修改代码的问题，但是缺点带来了工厂类变多，因此引入了抽象工厂，
        //通过添加工厂的工厂来管理抽象工厂

        //根据设计原则--一般采用工厂方法模式--满足开闭设计原则
        //根据实际业务--一般采用简单工厂模式--简单工厂便于管理


    }
}
