package com.tjpu.Function;

import java.util.function.Function;

/***
 * Function 函数型接口
 */
public class function_interface_demo {
    public static void main(String[] args) {

        //输出输入的值--工具类
//        Function function = new Function<String,String>(){
//
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };

        //lambda表达式简化
                Function function = (str)->{return str;};

        System.out.println(function.apply("asd"));
    }
}
