package com.tjpu.Algorithm_Code.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */
public class FirstMissingPositive_46 {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set =new HashSet<>();
        for(Integer num:nums){
            set.add(num);
        }
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length+1;
    }
}
