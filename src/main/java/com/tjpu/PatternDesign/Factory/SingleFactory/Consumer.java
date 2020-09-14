package com.tjpu.PatternDesign.Factory.SingleFactory;

public class Consumer {
    public static void main(String[] args) {
//        //------1.未使用工厂模式的得操作如下--------------\
//        //需要知道车、接口才行
//        Car car1= new WuLingCar();
//        Car car2 =new Tesla();
//        car1.name();
//        car2.name();


        //------2.使用工厂模式的得操作如下--------------\
        Car car1 =CarFactory.getCar("五菱");
        Car car2 =CarFactory.getCar("特斯拉");

        car1.name();
        car2.name();

    }
}
