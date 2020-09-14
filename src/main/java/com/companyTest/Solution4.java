package com.companyTest;

import java.util.Scanner;

/**
 * 回文素数
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 现有一个正整数，希望去掉这个数中某一个数字之后可以得到一个回文素数。
 *
 * 回文素数是指一个素数同时还是一个回文数（回文数即从左到右和从右到左均一样的数，例如12321）。【注意：一位数也被认为是回文数】
 *
 * 输入两个正整数N和M，满足N<M，请编写一个程序统计N和M之间存在多少个满足上述要求的数？
 *
 *
 *
 * 输入描述
 * 单组输入。
 *
 * 输入一行，包含两个正整数N和M，1<=N<M<=1000000，两个数字之间用空格隔开。
 *
 * 输出描述
 * 输出在N和M之间（包含N和M）满足要求的数的个数。
 *
 *
 * 样例输入
 * 110 120
 * 样例输出
 * 10
 *
 * 提示
 * 样例解释
 * 在110和120之间存在10个满足要求的数，分别是110、111、112、113、114、115、116、117、118和119，它们去掉最后一位数都可以得到一个回文素数11。120不符合。故最终结果为10
 */
class Main4 {

     public int getNumRes(int start,int end){
         int resNum=0;
         for (int i=start;i<=end;i++){
             if (isHuiWen(i)==1 && isSuShu(i)==1 ){
                 resNum++;
                 System.out.println("当前数字："+i+"满足");
             }else {
               if (isSatisfied(i)==1){
                   resNum++;
               }
             }
         }
        return resNum;
     }
     public int isSatisfied(int num){
         int temNum=num;
         int strLen=String.valueOf(num).length();
         int i=strLen;
         int j=strLen-1;
         while(isSuShu(temNum)!=1 && isHuiWen(temNum)!=1 && strLen>0 && j>1){
            String newStr = String.valueOf(temNum).substring(j,i);
            int newInt=Integer.parseInt(newStr);
            if (isSuShu(newInt)==1 && isHuiWen(newInt)==1){
                System.out.println("当前数字："+num+"满足111"+"newInt"+newInt);
                return 1;
            }
            strLen--;
            j--;

         }
       return 0;
     }


    public int isHuiWen(int n){
        int x=0;
        int s=n;
        while(s>0){
            x=x*10+s%10;
            s=s/10;
        }
        if(x==n){
            return 1;
        }else {
            return 0;
        }
    }
    public int isSuShu(int n){
        int x=n;
        int i;
        for (i=2;i<=n-1;i++){
            if (x%i==0){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Main4 main4 =new Main4();
        Scanner in =new Scanner(System.in);
        int start=Integer.parseInt(in.next());
        int end=Integer.parseInt(in.next());
        System.out.println(" ======="+start+"  "+end);
        System.out.println(main4.getNumRes(start,end));

    }
}
