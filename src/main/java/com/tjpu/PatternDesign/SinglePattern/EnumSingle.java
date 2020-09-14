package com.tjpu.PatternDesign.SinglePattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * enum是什么？枚举本身也是一个class类
 */
public enum EnumSingle {
    INSTANCE;
    public EnumSingle getInstance(){
        return INSTANCE;
    }
    //如何保证以上的INSTANCE对象一定是唯一的，以下做一个测试

}

class test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //===================以下测试表达了枚举能保证是单例的
//        EnumSingle instance1 =EnumSingle.INSTANCE;
//        EnumSingle instance2 =EnumSingle.INSTANCE;
//        System.out.println(instance1);
//        System.out.println(instance2);
        //===================以上测试表达了枚举能保证是单例的

        //===================以下测试通过反射构造方法不带参数=====================
//        EnumSingle instance1 =EnumSingle.INSTANCE;
//        //枚举里面有无参构造方法
//        Constructor<EnumSingle> declaredConstructors
//                = EnumSingle.class.getDeclaredConstructor(null);
//        declaredConstructors.setAccessible(true);
//        EnumSingle instance2 =  declaredConstructors.newInstance();
//        System.out.println(instance1);
//        System.out.println(instance2);
       // ===================以上测试发现报错没有空参的方法，事实上idea枚举代码里面有空参方法

        //===================以下测试通过反射构造方法带参数=====================
        EnumSingle instance1 =EnumSingle.INSTANCE;
        //枚举里面有无参构造方法
        Constructor<EnumSingle> declaredConstructors
                = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructors.setAccessible(true);
        EnumSingle instance2 =  declaredConstructors.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        // ===================结果报错，枚举无法破坏单例 Cannot reflectively create enum objects
    }
}
