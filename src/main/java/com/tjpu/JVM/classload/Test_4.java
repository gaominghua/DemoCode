package com.tjpu.JVM.classload;

public class Test_4 {

    public static void main(String[] args) {
        Test_4 arrs[] = new Test_4[1];
    }
}

class Test_4_A {
    static {
        System.out.println("Test_4_A Static Block");
    }
}
