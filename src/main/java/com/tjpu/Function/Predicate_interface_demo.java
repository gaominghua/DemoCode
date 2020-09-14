package com.tjpu.Function;

import java.util.function.Predicate;

/***
 * 断定型接口，有一个输入参数，返回值只能式Boolean值
 */
public class Predicate_interface_demo {
    public static void main(String[] args) {
        //判断字符串是否为空

//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//               return str.isEmpty();
//            }
//        };

        //lambda简化
        Predicate<String> predicate =(str)->{return str.isEmpty();};

        System.out.println(predicate.test(""));
    }

}
