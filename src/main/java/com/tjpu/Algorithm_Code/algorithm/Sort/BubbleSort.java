package com.tjpu.Algorithm_Code.algorithm.Sort;

import java.util.Arrays;


public class BubbleSort {
    /**
     * 选择排序---时间复杂度最好O(n)------最坏o(n^2)
     * @param arry
     */

    public static void bubbleSort(int[] arry){
        int length =arry.length;//待排元素得个数
        if(length<=1){
            return;
        }
        //进行冒泡
        for(int i=0 ;i<length;i++){
            System.out.println("当前是第"+(i+1)+"趟"+"=================================");
            //相邻元素得比较
            for (int j = 0; j<length-i-1; j++){
                System.out.println("当前比较的元素是"+arry[j]+" 和 "+arry[j+1]);
                if(arry[j]>arry[j+1]){
                    System.out.println("当前比较的元素是"+arry[j]+" 和 "+arry[j+1]+"并且"+arry[j]+"大于"+arry[j+1]);
                    int temp =arry[j];
                    arry[j]=arry[j+1];
                    arry[j+1]=temp;
                    System.out.println(arry[j]+" 和 "+arry[j+1]+"需要交换位置后结果是："+Arrays.toString(arry));
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] arry =new int[]{5,2,6,9,0,3};
        System.out.println("冒泡排序前得结果是---》："+ Arrays.toString(arry));
        bubbleSort(arry);
        System.out.println("冒泡排序得结果是---》："+ Arrays.toString(arry));
    }
}
