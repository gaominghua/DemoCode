package com.tjpu.java.Lambda;

public class interfacDemo {
    public static void main(String[] args) {
        Runnable run = new Runnable(){
            @Override
            public void run(){
                System.out.println("常规写法");
            }
        };
        Runnable run1 = () -> System.out.println("lambda");//{}中只有一条语句时，{}可以省略
        run.run();
        run1.run();
        //匿名函数的访问权限可以省略（跟接收变量的作用域保持一致，返回值和参数类型都可以编译器自动判断。
    }
}
