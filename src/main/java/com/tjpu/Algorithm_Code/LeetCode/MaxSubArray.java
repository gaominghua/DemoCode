package com.tjpu.Algorithm_Code.LeetCode;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    //动态规划
    // public int maxSubArray(int[] nums) {

    //     for(int i=1;i<nums.length;i++){
    //         if(nums[i-1]>0){
    //             nums[i]=nums[i-1]+nums[i];//如果i前面一个元素大于0，那么加到当前元素
    //         }

    //     }
    //     Arrays.sort(nums);
    //     System.out.print(Arrays.toString(nums));
    //     return nums[nums.length-1];

    // }
    //贪心策略：如果当前元素之前的和小于0那么直接丢弃
    public int maxSubArray(int[] nums) {

        int preSum=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            //如果当前元素之前的和小于0那么直接丢弃
            if(preSum>=0){
                nums[i]=preSum+nums[i];
            }
            preSum=nums[i];//把当前的值交给之前的和
        }

        Arrays.sort(nums);
        System.out.print(Arrays.toString(nums));
        return nums[nums.length-1];

    }

}
