package com.companyTest;


import java.util.Scanner;

class Main9 {
    public String decode(int len,String str){
        if (str.length()<len){
            return new StringBuilder(str).reverse().toString();
        }
        StringBuilder sb=new StringBuilder();
        int step=0;
        while (step<str.length()){
            if ((step+len)<=str.length()){
                sb.append(new StringBuilder(str.substring(step,step+len)).reverse().toString());
            }else {
                sb.append(new StringBuilder(str.substring(step)).reverse().toString());
            }

            step+=len;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Main9 main =new Main9();
        Scanner in =new Scanner(System.in);
        int stepLen=Integer.parseInt(in.nextLine());
        String str=in.nextLine();
        System.out.println(main.decode(stepLen,str));
    }
}
