package com.tjpu.Algorithm_Code.algorithm.Search;

import java.util.Arrays;

public class SimpleBinarySearch {
    //非递归方式二分查找
    public static  int BinarySearch(int[] arry,int value){
        int low=0;
        int high=arry.length-1;
        while(low<=high){
            //计算mid指针
            int mid=(low+high)/2;
            if(arry[mid]==value){
                return mid;
            }else if (arry[mid]<value){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    //递归方式二分查找
    public static int recursionBinarySearch(int[] arry,int value,int low,int high){
        if(low>=high){
            return -1;
        }
        //计算mid指针
        int mid=(low+high)/2;
        if (arry[mid]==value){
            return mid;
        }else if(arry[mid]<value){
            return recursionBinarySearch(arry,value,mid+1,high);
        }else{
            return recursionBinarySearch(arry,value,low,mid-1);
        }
    }

    public static void main(String[] args) {
        int[] arry =new int[]{6,12,15,19,24,26,29,35,46,67};
        System.out.println("查找前得结果是---》："+ Arrays.toString(arry));
//        int i=BinarySearch(arry,15);
        int i=recursionBinarySearch(arry,15,0,arry.length-1);
        System.out.println("查找的结果元素下标是---》："+i+"---对应的值是"+ arry[i]);
    }

}
