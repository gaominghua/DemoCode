package com.tjpu.PatternDesign.Builder.Demo2;

public class Test {
    public static void main(String[] args) {
        //服务员
        Worker worker = new Worker();

        //再原来的基础上可以自由组合，不组合也有默认的
        Product product =worker.builderA("全年桶")
                .builderB("雪碧")
                .getProduct();
        System.out.println(product.toString());

    }
}
