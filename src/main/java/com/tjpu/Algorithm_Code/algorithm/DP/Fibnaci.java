package com.tjpu.Algorithm_Code.algorithm.DP;

/**
 * 动态规划的思想优化斐波那契求解问题
 * 方式一：采用自顶向下备忘录法
 */
public class Fibnaci {

    //计算斐波那契数列

    /**
     *
     * @param n 计算斐波那契的某一项
     * @param memory 表示我们的备忘录
     * @return 返回计算某一项的结果
     */
    public static int fib(int n,int[] memory){
        //用-1表示备忘录中没有记录f(n)的值
        //如果备忘录中记录了该值那么直接返回
        if (memory[n]!=-1){
            return memory[n];
        }
        if (n<=2){
            memory[n]=1;
        }else {
            memory[n]=fib(n-1,memory)+fib(n-2,memory);
        }
        return memory[n];

    }

    public static int fibonac(int n){
        if (n<=0){
            return -1;
        }
        //创建备忘录
        int[] memory =new int[n+1];
        //给备忘录附初始值
        for (int i=0;i<=n;i++){
            memory[i]=-1;
        }
        return fib(n,memory);
    }

    public static void main(String[] args) {
        int res =Fibnaci.fibonac(7);
        System.out.println(res);
    }
}
