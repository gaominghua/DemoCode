package com.tjpu.Algorithm_Code.LeetCode;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int left=0; //左指针
        int right=0;//右指针
        int oddNum=0; //数组中奇数的个数
        int preEven=0; //第一个奇数之前的偶数个数
        int result=0; //结果个数

        //当右指针小于数组长度，一直向右移动
        while(right<nums.length){
            //如果奇数的个数小于指定的k那么指针右移动,移动的过程种计算奇数个数
            if(oddNum<k){
                if(nums[right]%2!=0) oddNum++;
                right++;
            }
            //如果奇数够k个，判断第一个奇数之前有多少个偶数
            if(oddNum==k){
                preEven=0;
                while(oddNum==k){
                    result++;
                    if(nums[left]%2!=0) oddNum--;
                    left++;
                    preEven++;
                }
            }else{
                result+=preEven;//把偶数的结果加上，例如：222有3个+1221有1个
            }

        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfSubarrays numberOfSubarrays= new NumberOfSubarrays();
        int[] nums1 =new int[]{2,2,2,1,2,2,1,2,2,2};
        int[] nums2 =new int[]{1,1,2,1};
        int[] nums3 =new int[]{2,2,2,1,2,2,1,2,2,2,1,2,2,2};
        int k=2;
        int result = numberOfSubarrays.numberOfSubarrays(nums2,k);
        System.out.println("最优子数组的个数是："+result);
    }
}
