package com.tjpu.Algorithm_Code.LeetCode;

import java.util.Arrays;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        //遍历数组，获得真个数组最终异或的结果
        //异或：相同位0，不同为1
        //例如：4：0100  4^4=0000 4^4^6=6
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum^=nums[i];
        }

        int first=1;//用来&操作将奇数和偶数分开
        //考虑如果异或的sum结果是偶数
        //那么需要将first<<1 左移动一位,找到最低位的1
        //例如：0110，那么最低位为1再第二个位子上  此时first<<1=0010 (1再第2位上)
        //因为异或的sum=偶数，再进行分类的时候只有对偶数进与运算才行
        while((sum&first)==0){
            first=first<<1;
            System.out.println("first:"+Integer.toBinaryString(first));
        }

        int[] res = new int[2];
        //通过&与操作将数组分成2部分
        for(int i=0;i<nums.length;i++){
            if((nums[i]&first)==0){//此时与操作得到改数是偶数
                res[0]^=nums[i];//通过异或操作消出重复的值
            }else{//此时与操作得到改数是奇数
                res[1]^=nums[i];//通过异或操作消出重复的值
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums= new int[]{1,2,5,2};
        SingleNumbers sn = new SingleNumbers();
        int[] res = sn.singleNumbers(nums);
        System.out.println(Arrays.toString(res));
    }
}
