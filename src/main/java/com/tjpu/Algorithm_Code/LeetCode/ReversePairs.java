package com.tjpu.Algorithm_Code.LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * leetcode 51.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 输入: [7,5,6,4]
 * 输出: 5
 */
class ReversePairs {
    private int sum;
    public int reversePairs(int[] nums) {
        sum=0;
        int left=0;//定义数组左指针
        int right=nums.length-1;//定义数组右指针
        divide(nums,left,right);
        return sum;
    }
    private void divide(int[] array,int left,int right){
        if(array.length<0||array.length>50000) return;
        if(left>=right) return;
        if(left!=right){//左右指针不相等
            int mid=(left+right)/2;//得到中间指进行递归划分
            divide(array,left,mid);//对左半部分进行二分
            divide(array,mid+1,right);//对右半部分进行二分
            //划分之后进行合并操作
            merge(array,left,mid,right);
        }
    }
    private void merge(int[] array,int left,int mid,int right){
        //假设已经划分道不可划分
        //左边边界
        int i=left;
        //右边边界
        int j=mid+1;
        int index=0;
        //定义一个临时数组保存可变得结果
        int[] temp = new int[right-left+1];

        while(i<=mid&&j<=right){
            if(array[i]>array[j]){
                temp[index++]=array[j++];
                sum+=mid-i+1;//统计逆序对个数，统计得基础是归并排序合并中
            }else{
                temp[index++]=array[i++];
            }
        }
        while(i<=mid){
            temp[index++]=array[i++];//将左边剩余元素填充进temp中
        }
        while(j<=right){
            temp[index++]=array[j++];//将右边剩余元素填充进temp中
        }
        index=0;
        for(int k=left;k<=right;k++){
            array[k]=temp[index++];
        }
    }

    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);
        System.out.println("输入数组得长度：");
        int len =in.nextInt();
        int[] nums =new int[len];
        System.out.println("输入数组：");
        for (int i = 0; i < nums.length; i++) {
            nums[i]= in.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        ReversePairs reversePairs =new ReversePairs();
        System.out.println("一共有多少个逆序数:"+reversePairs.reversePairs(nums));
    }

}