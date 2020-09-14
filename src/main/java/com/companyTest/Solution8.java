package com.companyTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


 class Main8 {
     public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        List<Integer> arrlist=new ArrayList();
        int num=in.nextInt();
         for (int i = 0; i <num ; i++) {
             arrlist.add(in.nextInt());
         }
         List<Integer> temList =new ArrayList<>();
         System.out.println(arrlist);
         int line=0;
         while (num>0){
             for ( Integer res:arrlist){
                 temList.add(res);
             }
             //System.out.println("temList:"+temList+" arraList:"+arrlist);
             temList.remove(line);
             int midNum=(temList.size()/2);
             System.out.println(temList.get(midNum));
             line++;
             num--;
             temList.clear();
         }
     }
}
