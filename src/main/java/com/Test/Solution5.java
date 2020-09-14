package com.Test;

import java.util.Scanner;

class Main5 {
    public  int  getChangeNum(String str){
        int end=str.length()-1;
        int start=0;
        int res=0;
        while(start<=end){
            if (str.charAt(start)!=str.charAt(end)){
                res++;
            }
            start++;
            end--;

        }
        return res;
    }

    public static void main(String[] args) {
        Main5 main5 =new Main5();
        Scanner in =new Scanner(System.in);
        int strLen=in.nextInt();
        StringBuilder sb=new StringBuilder();
        String str =sb.append(in.next()).substring(0,strLen);
        System.out.println(main5.getChangeNum(str));

    }

}
