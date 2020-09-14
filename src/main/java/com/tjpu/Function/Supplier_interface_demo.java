package com.tjpu.Function;

import java.util.function.Supplier;

/***
 * 供给型接口：没有参数，只有返回值
 */
public class Supplier_interface_demo {
    public static void main(String[] args) {

//        Supplier<Integer> supplier =new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return 1024;
//            }
//        };

        //lambda表达式简化
        Supplier<Integer> supplier =()->{return 1024;};


        System.out.println( supplier.get());

    }
}
