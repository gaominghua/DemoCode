package com.tjpu.Algorithm_Code.algorithm.Sort;

import java.util.Arrays;

public class InsertSort {


    /**
     * 插入排序---时间复杂度最好O(n)------最坏o(n^2)
     */
    public static void InsertSort(int[] arry){
        int len =arry.length;
        if (len<=1){
            return;
        }
        for (int i=1;i<len;i++){
            //取出当前序列中未排序的元素及当前要比较的元素
            int current=arry[i];

            //在有序区间从后往前扫描（下标）
            int preIndex = i-1;
            while(preIndex>=0&&arry[preIndex]>current){
                arry[preIndex+1]=arry[preIndex];
                preIndex--;
            }
            arry[preIndex+1]=current;
        }
    }

    public static void main(String[] args) {
        int[] arry =new int[]{5,2,6,9,0,3};
        System.out.println("插入排序前得结果是---》："+ Arrays.toString(arry));
        InsertSort(arry);
        System.out.println("插入排序得结果是---》："+ Arrays.toString(arry));
    }
}
