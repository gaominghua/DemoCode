package com.tjpu.Algorithm_Code.algorithm.Sort;

import java.util.Arrays;

public class SelectSort {

    /***
     * 选择排序---时间复杂度最好O(n^2)------最坏o(n^2)----平均复杂度O(n^2)---空间复杂度o(1)
     */
    public static void SelectSort(int[] arry){
        int len=arry.length;
        if (len==1){
            return;
        }
        for (int i=0;i<len;i++){
            int minIndex=i;
            //从未排序序列中找到最小值
            for (int j=i;j<len;j++){
                if (arry[minIndex]>arry[j]){
                    minIndex=j; //找到最小值
                }
            }
            //尾部最佳最小值
            int current=arry[i];
            arry[i]=arry[minIndex];
            arry[minIndex]=current;
        }
    }

    public static void main(String[] args) {
        int[] arry =new int[]{5,2,6,9,0,3};
        System.out.println("选择排序前得结果是---》："+ Arrays.toString(arry));
        SelectSort(arry);
        System.out.println("选择排序得结果是---》："+ Arrays.toString(arry));
    }
}
