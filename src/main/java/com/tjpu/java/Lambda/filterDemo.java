package com.tjpu.java.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class filterDemo {
    public static void main(String[] args) {
        // 输出结果
        // 2,4,6,8
        //filter：数据筛选，相当于if判断
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> collect = numberList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        collect.forEach(number -> System.out.print(number + ","));
    }
}
