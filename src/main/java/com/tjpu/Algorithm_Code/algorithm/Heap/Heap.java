package com.tjpu.Algorithm_Code.algorithm.Heap;

import java.util.Arrays;

public class Heap  {

    //创建堆
    //创建一个存储队中元素的数组
    private int[] data;
    //堆中存储数据最大的个数
    private int size;
    //堆中已经存储元素的个数
    private int count;
    /**
     * 构造一个使用数组进行存储的堆
     * @param cp 堆初始值的容量
     */
    public Heap(int cp){
        this.data=new int[cp+1];
        this.size=cp;
        this.count=0;
    }
    @Override
    public String toString() {
        return "Heap{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", count=" + count +
                '}';
    }

    /**
     * 从堆顶删除堆顶元素
     */
    public int removeMaxTop(){
        int max =data[1];
        data[1]=data[count--];
        this.heapTopToBottom(data,1,count);
        return max;
    }

    /**
     * 从堆中删除元素--【自顶向下的堆化】
     */
    private void heapTopToBottom(int[] data,int begin,int end){
        while (true){
            //定义最大值的下标
            int maxPosition=begin;
            //用当前节点和左右子节点比较，找出最大值
            if (2*begin<end && data[maxPosition]< data[2*begin]){
                maxPosition=2*begin;
            }
            if (2*begin+1<=end && data[maxPosition]<data[2*begin+1]){
                maxPosition=2*begin+1;
            }
            if (begin==maxPosition){
                break;
            }
            swp(data,begin,maxPosition);
            begin=maxPosition;

        }
    }


    /**
     * 向堆中插入元素【堆化过程--数据的交换，自底向上】
     */
    public void insert(int data){
        if (count>=size){
            return;//堆满无法存储
        }
        this.data[++count]=data;
        this.heapbottomTOtop(this.data,count);//进行堆化

    }

    /**
     * 自底向上堆化操作
     * @param data
     * @param end
     */
    private void heapbottomTOtop(int[] data,int end){
        int i = end;
        while (i/2>0&&this.data[i/2]<this.data[i]){
            swp(data,i/2,i);
            i=i/2;
        }
    }


    /**
     * 交换数组中下标为i和j的两元素
     * @param arry
     * @param i
     * @param j
     */
    private void swp(int[] arry ,int i,int j){
        int temp=arry[i];
        arry[i]=arry[j];
        arry[j]=temp;
    }
}
