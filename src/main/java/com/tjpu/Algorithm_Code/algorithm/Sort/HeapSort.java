package com.tjpu.Algorithm_Code.algorithm.Sort;

import java.util.Arrays;

/**
 * 演示堆排序
 */
public class HeapSort {

    /**
     * 建堆：
     * 1.堆化处理
     * 2.数据交换
     */

    //堆排序
    public static void heapSort(int[] arry){
        //1.建堆
        buildHeap(arry,arry.length-1);
        //2.排序
        sort(arry,arry.length-1);
    }
    //建堆操作
    private static void buildHeap(int[] arry, int n){
        for (int i=n/2;i>0;i--){
            heapTopToBottom(arry,i,n);
        }

    }

    //自顶向下的堆化
    private static void heapTopToBottom(int[] data, int begin, int end){
        while(true){
            //定义最大值下标
            int maxPosition = begin;
            //比较当前节点和左右子节点的关系，求出最大值
            if (2*begin<=end && data[maxPosition]<data[2*begin]){
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
     * 交换数组中下标为i和j的两元素
     * @param arry
     * @param i
     * @param j
     */
    private static void swp(int[] arry, int i, int j){
        int temp=arry[i];
        arry[i]=arry[j];
        arry[j]=temp;
    }
    /**
     * 排序：
     * 我们把堆顶元素跟最后一个元素互换,然后对 1~n-1 区间的元素再堆化,然后在
     将堆顶元素跟最后一个元素互换继续操作，
     * 有点类型删除堆顶元素
     * @param array
     */
    private static void sort(int[] array, int n){
        while (n > 1){
            swp(array,1,n);
            heapTopToBottom(array,1,--n);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[7];
        array[1] = 2;
        array[2] = 6;
        array[3] = 9;
        array[4] = 0;
        array[5] = 3;
        array[6] = 5;
        //进行排序
        System.out.println(Arrays.toString(array));
        heapSort(array);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}
