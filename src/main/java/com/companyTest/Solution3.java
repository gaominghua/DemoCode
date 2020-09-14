package com.companyTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * 求以下数列的和：
 *
 * f(n)=1/5-1/10+1/15-1/20+1/25-......+1/(5*(2*n-1))-1/(5*2*n)。
 *
 *
 *
 * 输入描述
 * 单组输入。
 *
 * 每组数据一个输入，每个输入一行，输入n。（n<=100）
 *
 * 输出描述
 * 输出数列前n项的和，结果四舍五入保留四位小数。
 *
 * 样例输入
 * 1
 * 样例输出
 * 0.1000
 */
class Main3 {
    public BigDecimal numToSum(int num){
       float res=0;

        for (int i=1;i<=num;i++){
                res= (float) (res+1/(5*(2.0*i-1))-1/(5*(2.0*i)));

        }
        BigDecimal bd=new BigDecimal(res);

        return  bd.setScale(4, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        Main3 main =new Main3();
        Scanner in =new Scanner(System.in);
        int num=in.nextInt();
        System.out.println(main.numToSum(num));
    }
}
