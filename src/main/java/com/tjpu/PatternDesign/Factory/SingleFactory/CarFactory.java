package com.tjpu.PatternDesign.Factory.SingleFactory;

/**
 * 简单工厂模式--静态工厂模式，如果需要添加一个车辆需要修改如下代码
 * 工厂模式-未能满足开闭原则，
 */
public class CarFactory  {
    public static Car getCar(String car ){

        //方法一
        if (car.equals("五菱")){
            return new WuLingCar();
        }else if (car.equals("特斯拉")){
            return new Tesla();
        }else{
            return null;
        }
    }
}
