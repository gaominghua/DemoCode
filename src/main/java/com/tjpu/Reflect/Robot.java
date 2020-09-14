package com.tjpu.Reflect;

public class Robot {

    private String name;//私有name属性
    //定义一个公有方法
    public void sayHi(String helloSentence){
        System.out.println(helloSentence+" "+name);
    }

    //定义一个私有方法
    private String throwHello(String tag){
       return "Hello "+tag;
    }

}
