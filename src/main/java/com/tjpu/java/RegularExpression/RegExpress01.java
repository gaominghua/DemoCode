package com.tjpu.java.RegularExpression;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class RegExpress01 {
    public static void main(String[] args) {


        /**
         \d 等价于 [0-9] 数字字符
         \D 等价于 [^0-9] 非数字字符
         \s 等价于 [ \t\n\x0B\f\r] 空白字符
         \S 等价于 [^ \t\n\x0B\f\r] 非空白字符
         \w 等价于 [a-zA-Z_0-9] 单词字符
         \W 等价于 [^a-zA-Z_0-9] 非单词字符

         量词
         * (贪婪) 重复零次或更多 (>=0)
         + (懒惰) 重复一次或更多次 (>=1)
         ? (占有) 重复零次或一次 （0||1） 要么有 要么没有
         {} 重复多少次的意思 可以有多少个
         {n} n次 （x=n）
         {n,} 重复n次或更多 (x>=n)
         {n,m} 重复出现的次数比n多但比m少 (n<=x<=m)
         x|y 一个 | x 或者 y

         **/
        String str = "啊啊啊  222";
        //匹配模式------------------------------------------------------------------
        String pattern0 = "[a-zA-Z][0-9]+";//获取字母+数字（+ 号代表前面的字符必须至少出现一次（1次或多次））
        String pattern1 = "[a-zA-Z]";//获取字母
        String pattern2 = "\\S";

        //匹配模式------------------------------------------------------------------
        Pattern patten = Pattern.compile(pattern2);//编译正则表达式
        Matcher matcher = patten.matcher(str);// 指定要匹配的字符串
        List<String> matchStrs = new ArrayList<>();
        while (matcher.find()) { //此处find（）每次被调用后，会偏移到下一个匹配
            matchStrs.add(matcher.group());//获取当前匹配的值
        }

        for (int i = 0; i < matchStrs.size(); i++) {
            System.out.println(matchStrs.get(i));

        }
    }
}
