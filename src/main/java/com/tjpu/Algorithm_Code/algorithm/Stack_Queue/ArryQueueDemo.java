package com.tjpu.Algorithm_Code.algorithm.Stack_Queue;

/**
 * 顺序队列
 */
public class ArryQueueDemo {
}

class ArryQueue{
    //定义队列结构


    //使用数组来存储队列
    private Object[] elements;
    //定义队列的大小
    private int size;
    //定义队列储初始容量
    private int DEFAULT_SIZE=10;
    //定义容量最大程度
    private int MAX_ARRY_SIZE=Integer.MAX_VALUE-8;

    //定义队列头指针
    private int head;
    //ding一队列尾指针；
    private int tail;

    /**
     * 定义一个默认初始化长度为10的队列
     */
    public ArryQueue(){
        elements=new Object[DEFAULT_SIZE];
        //初始化首尾指针
       this.initPoint(0,0);
    }

    /**
     * 用户可以根据传入的容量构建一个队列
     * @param capcity
     */
    public  ArryQueue(int capcity){
        if (capcity<=0){
            throw new RuntimeException("队列的初始容量不正确（不能小于0）");
        }
        elements=new Object[capcity];
        this.initPoint(0,0);
    }
    private void initPoint(int head,int tail){
        this.head=head;
        this.tail=tail;
    }

    //定义结构上的操作
    //入队列
    public boolean enqueue(Object element){
        //校验队列容量是否够用
        ensureSizeHelper();
        elements[tail++]=element;
        size++;
        return true;
    }
    //出队列
    public Object dequeue(){
        if (head==tail){
            return null;
        }
        Object object =elements[head++];
        size--;
        return object;
    }



    //判断队列容量是否够用
    private void ensureSizeHelper(){
        //尾指针已经越过数组长度
        if(tail==elements.length){
            if(size<elements.length){
                if (head==0){
                    //扩容操作
                }else{
                    for (int i=head;i<tail;i++){
                        elements[i-head]=elements[i];
                    }
                    initPoint(0,tail-head);
                }
            }
        }
    }
    //扩容方法
    private void grow(int oldSize){
        int newSize=oldSize+(oldSize>>1);//扩容1.5倍
        if(newSize-oldSize<0){
            newSize=DEFAULT_SIZE;
        }
        if (newSize-MAX_ARRY_SIZE>0){
            newSize=capcityFinal(newSize);
        }
    }

    private int capcityFinal(int newSize){
        return (newSize>MAX_ARRY_SIZE)?Integer.MAX_VALUE-8:newSize;
    }

}
