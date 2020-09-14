package com.tjpu.Algorithm_Code.algorithm.Search;

import java.util.Arrays;

/**
 * 数据序列中存在从夫元素的二分查找变形写法
 */
public class BinarySearch {
    /**
     * 查找数据序列中第一个等于给定值元素的下标
     */
    public static int binaryFirstSearch(int[] arry ,int value){

        //定义查找范围
        int low =0;
        int high=arry.length-1;
        while (low<=high){
            //中间指针mid计算
            int mid=(low+high)/2;
            if (arry[mid]==value){
                //当此时我们的mid指针已经指向第一个元素或者mid指针前一个元素不等于我们的查找元素的时候直接返回mid下标
                //否则继续二分查找
                System.out.println("此时arr["+mid+"]是："+arry[mid]);
                if (mid==0 || arry[mid-1]!=value){
                    return mid;
                }else {
                    high=mid-1;
                }
            }else if (arry[mid]<value){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    /**
     * 查找数据序列中最后一个等于给定值元素的下标
     */
    public static int binaryLastSearch(int[] arry ,int value){

        //定义查找范围
        int low =0;
        int high=arry.length-1;
        while (low<=high){
            //中间指针mid计算
            int mid=(low+high)/2;
            if (arry[mid]==value){
                //当此时我们的mid指针已经指向最后一个元素或者mid指针指向元素的下一个元素不等于查找的value，直接返回中间指针下标mid
                //否则继续二分查找
                System.out.println("此时arr["+mid+"]是："+arry[mid]);
                if (mid==arry.length-1 || arry[mid+1]!=value){
                    return mid;
                }else {
                    low=mid+1;
                }
            }else if (arry[mid]<value){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    /**
     * 查找数据序列中第一一个大于等于给定值元素的下标
     */
    public static int binarySearch3(int[] arry ,int value){
        //定义查找范围
        int low =0;
        int high=arry.length-1;
        while (low<=high){
            //中间指针mid计算
            int mid=(low+high)/2;
            if (arry[mid]>=value){
                System.out.println("此时arr["+mid+"]是："+arry[mid]);
                if (mid==0 || arry[mid-1]<value){
                    return mid;
                }else {
                    high=mid-1;
                }
            }else if (arry[mid]<value){
                low=mid+1;
            }
        }
        return -1;
    }
    /**
     * 查找数据序列中最后一个小于等于给定值元素的下标
     */
    public static int binarySearch4(int[] arry ,int value){
        //定义查找范围
        int low =0;
        int high=arry.length-1;
        while (low<=high){
            //中间指针mid计算
            int mid=(low+high)/2;
            if (arry[mid]<=value){
                System.out.println("此时arr["+mid+"]是："+arry[mid]);
                if (mid==arry.length-1 || arry[mid+1]>value){
                    return mid;
                }else {
                    low=mid+1;
                }
            }else if (arry[mid]<value){
                low=mid+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arry =new int[]{6,12,15,19,24,26,29,29,29,67};
        System.out.println("查找前得结果是---》："+ Arrays.toString(arry));
        int i=binarySearch4(arry,28);
        System.out.println("查找的结果元素下标是---》："+i+"---对应的值是"+ arry[i]);
    }
}
