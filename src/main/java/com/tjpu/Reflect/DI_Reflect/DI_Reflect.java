package com.tjpu.Reflect.DI_Reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DI_Reflect {
    @Test
    public void test() throws Exception {
        UserController userController =new UserController();
        //通过反射获取userController的类型
        Class<? extends UserController> clazz = userController.getClass();
        //创建对象
        UserService userService = new UserService();
        System.out.println(userService);

        //获取clazz的某个具体属性，通过传入属性名称
        Field serviceField = clazz.getDeclaredField("userService");
        //即使该字段是private，设置许可访问
        serviceField.setAccessible(true);

        //需要通过反射调用set方法来设置具体的属性值，即设置userService对象
        //拼接setUserService方法名
        String name =serviceField.getName();//得到该属性的名字
        name=name.substring(0,1).toUpperCase()+name.substring(1,name.length());
        String setMethodName ="set"+name;//得到这个方法名字

        //通过方法注入属性对象
        Method method = clazz.getMethod(setMethodName, UserService.class);
        //反射
        method.invoke(userController,userService);

        System.out.println(userController.getUserService());//通过反射注入的对象和未注入的对象一样
    }
}
