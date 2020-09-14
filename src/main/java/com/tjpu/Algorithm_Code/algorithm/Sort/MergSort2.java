package com.tjpu.Algorithm_Code.algorithm.Sort;

import java.util.Arrays;

public class MergSort2 {

    public static void mergSort2(int[] nums){
        int left=0;
        int right=nums.length-1;
        divide2(nums,left,right);
    }

    private static void divide2(int[] nums, int left, int right) {
        //如果左指针大于右指针直接返回
        if(left>right) return;
        //如果左右指针不相等则继续二分
        if(left!=right){
            int mid=(left+right)/2;
            divide2(nums,left,mid);
            divide2(nums,mid+1,right);
            //划分到最后一层每个元素都是独立的之后开始合并
            merge(nums,left,mid,right);
        }

    }

    private static void merge(int[] nums, int left, int mid, int right) {
        //此时划分的已经无法再继续划分
        //定义左边的边界
        int i=left;
        int j=mid+1;
        int index=0;//用于临时数组的指针
        //定义一个临时数组保存可变的结果
        //数组长度是right-left+1，因为如意[1,2] [2,4]合并，那么left=0,right=3 长度3-0+1=4
        int[] temp =new int[right-left+1];
        //此时开始判断左边的元素是否大于右边，如果大于右边元素那么需要交换
        //i<=mid&&j<=right 指的是当划分只有1个元素的时候情况
        while (i<=mid&&j<=right){
            if (nums[i]>nums[j]){
                temp[index++] = nums[j++];
            }else{
                temp[index++] = nums[i++];
            }
        }
        //i<=mid 指的是划分不知一个元素的情况，这个时候j是大于右指针的
        while(i<=mid){
            temp[index++] =nums[i++];
        }
        //j<=right 指的是划分不知一个元素的情况，这个时候i是大于mid指针的
        while(j<=right) {
            temp[index++] = nums[j++];
        }
        index=0;
        //将排序号的数组重新复制给nums数组
        for(int k=left;k<=right;k++){
            nums[k]=temp[index++];
        }
    }

    public static void main(String[] args) {
        int[] arry =new int[]{5,2,6,9,0,3,5};
        System.out.println("合并排序前得结果是---》："+ Arrays.toString(arry));
        mergSort2(arry);
        System.out.println("合并排序得结果是---》："+ Arrays.toString(arry));
    }
}
