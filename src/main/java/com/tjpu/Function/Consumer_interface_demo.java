package com.tjpu.Function;

import java.util.function.Consumer;

/***
 * 消费型接口:只有输入没有返回值
 */
public class Consumer_interface_demo {
    public static void main(String[] args) {

        //打印字符串
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
//
        //打印字符串，lambda表达式简化
        Consumer<String> consumer =(str)->{ System.out.println(str);};
        consumer.accept("aaaa");


    }
}
