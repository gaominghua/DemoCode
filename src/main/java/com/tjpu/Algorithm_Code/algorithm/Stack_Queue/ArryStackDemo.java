package com.tjpu.Algorithm_Code.algorithm.Stack_Queue;

/**
 * 顺序栈的实现
 */
public class ArryStackDemo{


    public static void main(String[] args) {
        ArryStack arryStack = new ArryStack();
        for (int i = 0; i < 13; i++) {
            boolean push = arryStack.push(i);
            System.out.println("第"+(i+1)+"次存储的数据为："+i+",存储的结果是："+push);
        }
        //出栈
        for (int i = 0; i < 11; i++) {
            Object obj =arryStack.pop();
            System.out.println("第"+(i+1)+"次出栈："+i+",出栈的结果是："+obj);
        }
    }
}


class ArryStack {
    //栈的大小
    private int size;
    //默认栈的容量
    private int DEFAULT_CAPACITY=10;
    //栈的数据
    private Object[] elements;

    private int MAX_ARRAY_SIZE=Integer.MAX_VALUE-8;

    //默认构造创建大小为10的栈
    public ArryStack(){
        elements=new Object[DEFAULT_CAPACITY];
    }
    //通过指定大小创建栈
    public ArryStack(int capacity){
        elements=new Object[capacity];
    }
    //入栈方法
    public boolean push(Object element){
        try {
            checkCapacity(size+1);
            elements[size++]=element;
            return true;
        }catch (RuntimeException e){
            return false;
        }
    }
    //检查栈的容量是否够用
    private void checkCapacity(int minCapacity){
        if(elements.length-minCapacity<0){
            throw new  RuntimeException("栈容量不够");
        }

    }
    //出栈方法
    public  Object pop(){

        if (size<=0){

            return null;//栈为空直接返回null值
        }
        Object object = elements[size-1];
        elements[--size]=null;
        return object;
    }
    //获取栈的大小
    public int size(){
        return size;
    }


}
