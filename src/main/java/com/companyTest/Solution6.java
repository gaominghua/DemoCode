package com.companyTest;


import java.util.Scanner;
/*
时间限制： 3000MS
内存限制： 589824KB
题目描述：
正整数n的阶乘(n!)中的末尾有多少个0?

例如：n = 5, n! = 120.末尾有1个0

实现：int CountZero(int n);
 */
 class Main6 {
     public int CountZero(int n){
         int resNum=0;
         while (n!=0){
             resNum+=n/5;
             n=n/5;
         }
         return resNum;

     }
     public static void main(String[] args) {
         Main6 main =new Main6();
         Scanner in =new Scanner(System.in);
         int num = in.nextInt();
         System.out.println(main.CountZero(num));


     }
}
