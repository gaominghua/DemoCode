package com.tjpu.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> robotClass = Class.forName("com.tjpu.Reflect.Robot");
        Robot robot = (Robot) robotClass.newInstance(); //获取对象实例

        System.out.println("通过反射获取到了这个类的名字是："+robotClass.getName());

        //通过反射获取类的方法GetDeclaredMethod 可以获取私有方法
        Method getHello = robotClass.getDeclaredMethod("throwHello",String.class);//String.class 代表接受参数类型
        getHello.setAccessible(true); //默认是false，私有方法无法访问
        Object str = getHello.invoke(robot,"Bob");//给robot对象实例的，getHello方法传入值Bob
        System.out.println("通过反射获取到throwHello私有方法："+str);

        //获取非私有方法
        Method sayHi = robotClass.getDeclaredMethod("sayHi",String.class);//String.class 代表接受参数类型
        sayHi.invoke(robot,"Welcome");

        //获取私有类型属性
        Field name = robotClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot,"Alice");
        sayHi.invoke(robot,"Welcome");


    }
}
