package com.tjpu.Reflect.DI_Reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.stream.Stream;

public class DI_Reflect_Annotation {

    @Test
    public void test(){
        UserController userController =new UserController();
        //通过反射获取userController的类型
        Class<? extends UserController> clazz = userController.getClass();
        //创建对象
        //UserService userService = new UserService();
        //获取所有的属性值
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name =field.getName();
            AutoWired annotation = field.getAnnotation(AutoWired.class);
            if (annotation!=null){
                field.setAccessible(true);
                //获取属性的类型
                Class<?> type = field.getType();//得到属性的类型，userService的类型是UserService.class
                try {
                    Object o = type.newInstance();//这里通过UserService.calss类型帮我们new出了userService对象
                    field.set(userController,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        });
        System.out.println(userController.getUserService());
    }
}
