package com.tjpu.Algorithm_Code.Offer;

import java.math.BigInteger;

/***
 * 递归求n得阶乘：
 */
public class nFactorial {
//公式0！=1 n！=n*（n-1）！
    public static int factorial(int n){
        if (n==0) {
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
    //bigInteger可以解决数据太大得问题
    public static BigInteger factorial2(int n){
        if (n==0) {
            return BigInteger.ONE;
        }else{
            return BigInteger.valueOf(n).multiply(factorial2(n-1));
        }
    }

    public static void main(String[] args) {
        System.out.println("5得阶乘是--->"+factorial2(10));
    }
    //阶乘当n足够大得时候可以用什么存储？数组处理阶乘问题

}
