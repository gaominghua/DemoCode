package com.tjpu.Algorithm_Code.LeetCode;

import java.util.*;

/**
 * lettcode 394
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
class DecodeString {

    public String decodeString(String s) {
        StringBuilder sb =new StringBuilder();//定义sb用来存最终结果
        Stack<Integer> stack1 = new Stack<>();//如果是数字则入栈1
        Stack<String> stack2 = new Stack<>();//如果是字符串则入栈2
        int multi =0;
        char[] sCharArray =s.toCharArray();//转char[]遍历
        for (char c : sCharArray) {
            if (c == '[') {//如果是'['
                stack1.push(multi);//将需要数字放入栈1
                stack2.push(sb.toString());//将字符放入栈2，最开始sb为” “，每次存放的是上一次的结果
                multi = 0;//每次放入数字要恢复成0
                sb = new StringBuilder();//每次字符串放入也要恢复成” “；
            } else if (c == ']') {
                StringBuilder tmp =new StringBuilder();//定义一个临时存放sb
                Integer timesTotal = stack1.pop();//取出栈2结果，如果是第一次则为空，如果不是第一次则每次是上一次的结果
                for (int times = 0; times < timesTotal; times++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder( stack2.pop()+tmp);//每次将上一次结果添加最新结果，重新赋值sb
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(String.valueOf(c));
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str ="2[abc]3[cd]ef";
        DecodeString solution =new DecodeString();
        System.out.println(solution.decodeString(str));
    }
}