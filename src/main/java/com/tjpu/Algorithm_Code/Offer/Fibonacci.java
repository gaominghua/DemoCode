package com.tjpu.Algorithm_Code.Offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("非递归--->"+Fibonacci(20));
        System.out.println("递归--->"+Fibonacci(20));
    }


    public static int Fibonacci(int n) {
        //1 1 2 3 5 8 13 21\
        int sum=0;
        int n0=0;
        int n1=1;
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        for(int i=2;i<=n;i++){
            sum=n0+n1;
            int temp=n1;
            n1=sum;
            n0=temp;
        }
        return sum;

    }

    /**
     * 递归方案
     * @param n
     * @return
     */
    public static int Fibonacci1(int n) {
        //1 1 2 3 5 8 13 21\
       if (n==1){
           return 1;
       }else if (n==2){
           return 1;
       }else {
           return Fibonacci1(n-1)+Fibonacci1(n-2);
       }

    }
}




