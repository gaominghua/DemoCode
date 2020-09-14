package com.tjpu.Algorithm_Code.LeetCode;

/**
 * leetcode 面试46
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b
 * ，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class TranslateNum {
    public int translateNum(int num) {

        String numStr =String.valueOf(num);
        int numLen=numStr.length();
        int prev1=1;
        int prev2=1;
        for(int i=1;i<numLen;i++){
            char p=numStr.charAt(i-1);
            char q=numStr.charAt(i);
            int curr=prev1;
            if(p=='1'){
                curr+=prev2;
            }
            if(p=='2'&&q>='0'&&q<='5'){
                curr+=prev2;
            }
            prev2=prev1;
            prev1=curr;
            System.out.println("当前的i："+numStr.charAt(i)+" prev1:"+prev1+" --prev2:"+prev2);

        }

        return prev1;
    }

    public static void main(String[] args) {
        TranslateNum translateNum =new TranslateNum();
        System.out.println(translateNum.translateNum(11258));
    }
}
