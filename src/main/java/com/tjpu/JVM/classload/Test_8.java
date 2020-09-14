package com.tjpu.JVM.classload;

public class Test_8 {

    static {
        System.out.println("Test_8 Static Block");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.tjpu.JVM.classload.Test_1_A");
    }
}
