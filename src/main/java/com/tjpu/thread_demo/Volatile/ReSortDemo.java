package com.tjpu.thread_demo.Volatile;

public class ReSortDemo {
    int a=0;
    boolean flag =false;
    public void  method01(){
        a=1;            // 语句1
        flag=true;      // 语句2   语句1和语句2不存在数据依赖性因此可能发生指令重排

    }
    //多线程环境中线程交替执行，由于编译器优化重排的存在
    //两个线程中使用的变量能否保证一致性是无法确定的，结果是无法预测的
    public void method02(){
        if (flag){
            a=a+5;      //语句3
            System.out.println("*****************retValue:"+a);
        }
    }
}
