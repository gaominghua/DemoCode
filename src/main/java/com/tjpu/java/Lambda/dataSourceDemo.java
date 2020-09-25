package com.tjpu.java.Lambda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class dataSourceDemo {
    public static void main(String[] args) throws FileNotFoundException {

        List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        String[] nameArr = {"Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter"};
        // 集合获取 Stream 流
        Stream<String> nameListStream = nameList.stream();
        // 集合获取并行 Stream 流
        Stream<String> nameListStream2 = nameList.parallelStream();
        // 数组获取 Stream 流
        Stream<String> nameArrStream = Stream.of(nameArr);
        // 数组获取 Stream 流
        Stream<String> nameArrStream1 = Arrays.stream(nameArr);

        // 从静态方法获取流操作
        IntStream rangeStream = IntStream.range(1, 10);
        rangeStream.limit(10).forEach(num -> System.out.print(num+","));
        System.out.println("=============================================");
        IntStream intStream = IntStream.of(1, 2, 3, 3, 4);
        intStream.forEach(num -> System.out.print(num+","));
        System.out.println("=============================================");

    }
}
