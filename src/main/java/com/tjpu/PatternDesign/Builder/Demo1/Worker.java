package com.tjpu.PatternDesign.Builder.Demo1;

//具体的建造者；工人
public class Worker extends Builder {
    private Product product;

    public Worker(){
        product=new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("地基");
        System.out.println("地基");
    }

    @Override
    void buildB() {
        product.setBuildB("钢筋工程");
        System.out.println("钢筋工程");
    }

    @Override
    void buildC() {
        product.setBuildB("(电线工程");
        System.out.println("电线工程");
    }

    @Override
    void buildD() {
        product.setBuildB("粉刷工程");
        System.out.println("粉刷工程");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
