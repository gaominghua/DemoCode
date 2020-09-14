package com.tjpu.Algorithm_Code.algorithm.Sort;

import java.util.Arrays;

/**
 * 快速排序：
 *  1.从数据序列找到一个分区点【基准点】
 *  2.从新排序数列，将其余元素和分区点元素进行比较
 *          比基准点小--放在左边，比基准点大放在右边
 *  3.继续做以上2步操作，因此需要递归
 *
 */
public class QuickSort {

    //快速排序方案2，输入时一个数组
    public static void quickSort(int[] nums, int start, int end){
        //判断数组是否合法
        if (nums.length<=1||start>end){
            return;
        }
        // 进行分区得到基准元素的下标
        int  baseIndex =partition(nums,start,end);
        //根据基准点进行递归
        //递归（左侧快排）
        quickSort(nums,start,baseIndex-1);
        ////递归（右侧快排）
        quickSort(nums,baseIndex+1,end);

    }
    // 4 5 1 3 2
    //以下部分进行分区，左半部分小于base |基准点位置| 右半部分大于base 所以需要返回基准点位置
    private static int partition(int[] nums, int start, int end) {
        //开始以数组的末尾元素为基准点进行分区
        int base=nums[end];
        //定义分区后基准点的位置下标，作用将数组分成做部分比base小，右部分比base大，最后返回这个baseIndex
        int baseIndex =start;
        //遍历基准点前的位置，如果某个元素大于基准点位置的元素，那么需要将其移动到基准点的位置
        for(int i=start;i<end;i++){//遍历整个数组的，比基准点大的数组不动，小的数字和baseIndex交换位置然后baseIndex后移，这样就把小的移动到左边，大的移动到右边
            if (nums[i]<base){//因为元素小与基准点
                if (i>baseIndex){
                    //交换两个元素
                    swap(nums,i,baseIndex);
                }
                baseIndex++;//因为元素小与基准点，该指针后移下一位
            }
        }
        //当遍历完之后，将最后将数组最后一个元素和此时基准点交换，这样最后一个元素成为基准点
        swap(nums,baseIndex,end);
        //于是便得到基准点得下标
        return  baseIndex;
    }
    private static void swap(int[] arr, int i, int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    public static void main(String[] args) {
        int[] arry =new int[]{5,2,6,9,0,3,4};
        System.out.println("快速排序前得结果是---》："+ Arrays.toString(arry));
        quickSort(arry,0,arry.length-1);
        System.out.println("快速排序得结果是---》："+ Arrays.toString(arry));
    }

}
