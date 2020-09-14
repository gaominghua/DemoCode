package com.tjpu.Algorithm_Code.LeetCode;

import java.util.*;

/**
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
 * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。

 *
 * 示例 1：
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 *
 * 示例 2：
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 *
 * 示例 3：
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 */
public class FindBestValue_1300 {

    public int findBestValue(int[] arr, int target) {
        int len=arr.length;
        Arrays.sort(arr);
        int value=arr[len-1];
        int sum=getSum(arr,value);
        if(sum<=target)
            return value;
        int left=0;
        int right=arr[len-1];
        int mid=0;
        int tmpSum=0;
        while(left<=right){
            mid=(left+right)/2;
            tmpSum=getSum(arr,mid);
            if(tmpSum==target){
                return mid;
            }
            if(tmpSum>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        if(target-getSum(arr,right)<=getSum(arr,left)-target)
            return right;
        else
            return left;
    }
    int getSum(int[] arr, int value){
        int res=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<value)
                res+=arr[i];
            else{
                res+=value*(arr.length-i);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5};
        int taget=10;
        FindBestValue_1300 findBestValue =new FindBestValue_1300();
        System.out.println(findBestValue.findBestValue(arr, taget));
    }

}
