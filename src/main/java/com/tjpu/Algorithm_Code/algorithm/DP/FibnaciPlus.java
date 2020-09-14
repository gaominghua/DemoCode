package com.tjpu.Algorithm_Code.algorithm.DP;

/**
 * 动态规划思想解决斐波那契额 重复计算 自底向上
 */
public class FibnaciPlus {

    public static int fb(int n){
        //数据合法性校验
        if(n<=0){
            return -1;
        }

        //创建备忘录
        int[] memory =new int[n+1];
        memory[1]=1;//f(1)=1
        memory[2]=1;//f(2)=1
        for (int i=3;i<=n;i++){
            memory[i]=memory[i-1]+memory[i-2];
        }

        return memory[n];

    }

    public static void main(String[] args) {
        int res =FibnaciPlus.fb(7);
        System.out.println(res);
    }
}
