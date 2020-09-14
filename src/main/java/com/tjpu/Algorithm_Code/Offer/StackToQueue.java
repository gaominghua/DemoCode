package com.tjpu.Algorithm_Code.Offer;

import java.util.Scanner;
import java.util.Stack;

class StackToqueue{
    Stack<Integer> stack1 =new Stack<Integer>();
    Stack<Integer> stack2 =new Stack<Integer>();
    public void push(int node){
        stack1.push(node);
    }
    public int pop(){
        Integer re =null;
        if(!stack2.empty()){
            re=stack2.pop();
        }else{
            while(!stack1.empty()){
                re=stack1.pop();
                stack2.push(re);
            }
            if(!stack2.empty()){
                re = stack2.pop();
            }
        }
        return re;
    }
    public int peek(){
        Integer re =null;
        if(!stack2.empty()){
            re=stack2.peek();
        }else{
            while(!stack1.empty()){
                re=stack1.pop();
                stack2.push(re);
            }
            if(!stack2.empty()){
                re = stack2.peek();
            }
        }
        return re;
    }

}

class Main {
    public static void main(String[] args) {
        StackToqueue stq =new StackToqueue();
        Scanner in = new Scanner(System.in);
        int operNums=Integer.parseInt(in.nextLine());
        String[] str=new String[operNums];

        for(int i=0;i<str.length;i++){
            str[i]=in.nextLine();
            System.out.println("==当前是:"+i+" 插入值："+str[i]);

        }

        for (int i = 0; i < str.length; i++) {
            String[] newStr = str[i].split(" ");
            if (newStr.length==2){
                if (newStr[0].equals("add")){
                    stq.push((Integer.parseInt(newStr[1])));
                }
            }
            if (newStr.length==1){
                if (newStr[0].equals("peek")){
                    System.out.println(stq.pop());
                }
                if (newStr[0].equals("poll")){
                   stq.peek();
                }
            }

        }

    }
}