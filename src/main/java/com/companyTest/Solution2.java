package com.companyTest;

import java.util.Arrays;
import java.util.Scanner;

class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums=in.nextInt();
        System.out.println("输入"+nums+"个数字");
        int[] arrNum= new int[nums];
        for (int i=0;i<arrNum.length;i++){
            arrNum[i]=Integer.parseInt(in.next());
        }
        System.out.println("得到的数组是："+ Arrays.toString(arrNum));
    }

}
