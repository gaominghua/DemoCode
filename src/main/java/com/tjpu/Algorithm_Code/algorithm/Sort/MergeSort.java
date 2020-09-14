package com.tjpu.Algorithm_Code.algorithm.Sort;


import com.sun.scenario.effect.Merge;

import java.util.Arrays;

public class MergeSort {
    /**
     * 合并排序算法：将一个数组从中间部分分成2份，然后对前2个部分分别排序，再将排序好的俩部分合并
     *---时间复杂度最好O(nlogn)------最坏o(nlogn)----平均复杂度O(nlogn)---空间复杂度o(n)
     */
    public static int[] mergeSort(int[] arry){
        if (arry.length<2){
            return arry;
        }
        //将我们的数组拆分成两个部分，
        int mid=arry.length/2;
        int[] left= Arrays.copyOfRange(arry,0,mid);
        System.out.println("左部分数组------>"+Arrays.toString(left));
        int[] right= Arrays.copyOfRange(arry,mid,arry.length);
        System.out.println("右部分数组------>"+Arrays.toString(right));

        //分解并合并
        return merge(mergeSort(left),mergeSort(right));
    }

    /**
     * 合并数组
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left,int[] right){
        //创建新的数组长度未2个数组长度之和
        int[] newArry=new int[left.length+right.length];

        //定义两个指针分别代表两个数组的下标
        int lIndex =0;
        int rIndex=0;

        for (int i=0;i<newArry.length;i++){
            if (lIndex>=left.length){
                newArry[i]=right[rIndex++];
            }else if (rIndex>=right.length){
                newArry[i]=left[lIndex++];

            }else if(left[lIndex]<right[rIndex]){
                newArry[i]=left[lIndex++];//如果左边数组指针指向的元素小于右边数组指针指向的元素 那么左边的元素放入newArray
            }else {
                newArry[i]=right[rIndex++];//如果左边数组指针指向的元素>于右边数组指针指向的元素 那么右边的元素放入newArray
            }
        }
        return newArry;
    }
    public static void main(String[] args) {
        int[] arry =new int[]{5,2,6,9,0,3,5};
        System.out.println("合并排序前得结果是---》："+ Arrays.toString(arry));
        arry=mergeSort(arry);
        System.out.println("合并排序得结果是---》："+ Arrays.toString(arry));
    }
}
