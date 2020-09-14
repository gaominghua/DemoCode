package com.tjpu.Algorithm_Code.algorithm.Sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {


    public static void countingSort(int[] array){
        //求出待排序的数组中的最大值，找出取值区间
        int max=array[0];
        int min=array[0];
        for (int i = 0; i<array.length; i++){
            if (array[i]>max){
                max=array[i];
            }
            if (array[i]<min){
                min=array[i];
            }
        }
        //定义一个额外的数组
        int bucketSize=(max-min)+1;
        int[] bucket = new int[bucketSize];
        //统计对应元素的个数
        for (int i=0;i<array.length;i++){
            int bucketIndex=array[i]-min;
            bucket[bucketIndex]+=1;
        }
        //对数组中的元素进行累加操作
        for(int i=1;i<bucket.length;i++){
            bucket[i]=bucket[i]+bucket[i-1];
        }
        //创建临时数组，来存储最终有序的序列
        int[] temp = new int[array.length];

        //逆序扫描待排序的数组，可以保证我们元素的稳定性
        for(int i=array.length-1;i>=0;i--){
            int bucketIdex=array[i]-min;
            temp[bucket[bucketIdex]-1]=array[i];
            bucket[bucketIdex]-=1;
        }
        //将临时数据依次放入原始数组中
        for(int i=0;i<temp.length;i++){
            array[i]=temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arry =new int[]{5,2,6,9,0,3};
        System.out.println("计数排序前得结果是---》："+ Arrays.toString(arry));
        countingSort(arry);
        System.out.println("计数排序得结果是---》："+ Arrays.toString(arry));
    }










}
