package com.tjpu.Algorithm_Code.LeetCode;

import java.util.*;

public class PatternMatching {
    public boolean patternMatching(String pattern, String value) {
        Map<Character,Integer> map= new HashMap<>();
        StringBuilder sb =new StringBuilder();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])){
                map.put(chars[i],0);
            }

        }


        return true;

    }
    public String reverseStr(String pattern){
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='a'){
                chars[i]='b';
            }else if (chars[i]=='b'){
                chars[i]='a';
            }
        }
        return  String.valueOf(chars);
    }

    public static void main(String[] args) {
        PatternMatching p =new PatternMatching();
        String pattern = "abba";
        System.out.println(p.reverseStr(pattern));
    }

}

