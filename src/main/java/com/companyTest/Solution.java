package com.companyTest;


import java.util.Arrays;
import java.util.Scanner;
/**
 * 题目描述：
 * 杰夫非常喜欢种草，他自己有一片草地，为了方便起见，我们把这片草地看成一行从左到右，并且第 i 个位置的草的高度是hi。
 * 杰夫在商店中购买了m瓶魔法药剂，每瓶魔法药剂可以让一株草长高x，杰夫希望每次都能有针对性的使用药剂，也就是让当前长得最矮的小草尽量高，现在杰夫想请你告诉他在使用了m瓶魔法药剂之后，最矮的小草在这种情况下最高能到多少。
 *
 * 输入描述
 * 第一行三个整数n, m, x分别表示小草的个数，魔法药剂的个数以及每瓶魔法药剂让小草长高的高度。(1≤n,m,x≤1e5)
 * 第二行n个整数分别表示第i株小草的高度ai。(1≤ai≤1e9)
 * 输出描述
 * 使用了m瓶药剂之后最矮的小草的最高高度。
 */

/**
 样例输入
 3 1 1
 1 2 3
 样例输出
 2
 */
class Main {

    public int getMBottonMinHeigth(int waterNum,int heigthNum,int[] flowerFarm){

        for (int i=0;i<waterNum;i++){
            Arrays.sort(flowerFarm);
            flowerFarm[0]=flowerFarm[0]+heigthNum;
        }
        return flowerFarm[0];
    }

    public static void main(String[] args) {
        int glassNum=0;
        int waterNum=0;
        int heightNum=0;

        Scanner in = new Scanner(System.in);

         glassNum=Integer.parseInt(in.next());
         waterNum=Integer.parseInt(in.next());
         heightNum=Integer.parseInt(in.next());
        //System.out.println("花个数："+glassNum+"魔法水个数："+waterNum+" 单瓶魔法水效果"+heightNum+"m");

        int[] flowerFarm=new int[glassNum];
        for (int i=0;i<flowerFarm.length;i++){
            flowerFarm[i]=Integer.parseInt(in.next());
        }
        //System.out.println("花圃高度："+ Arrays.toString(flowerFarm));
        Main main =new Main();
        System.out.println(main.getMBottonMinHeigth(waterNum,heightNum,flowerFarm));
    }

}
