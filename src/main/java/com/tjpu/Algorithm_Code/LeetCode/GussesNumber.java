package com.tjpu.Algorithm_Code.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * leetcode 299
 * 游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，
 *告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字
 *
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 *
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 */
public class GussesNumber {
    public String getHint(String secret, String guess) {
        int A=0;
        int B=0;
        int p1=0;
        char[] secretArr =secret.toCharArray();
        char[] guessArr =guess.toCharArray();
        Map<Character,Integer> mapS =new HashMap<>();
        Map<Character,Integer> mapG =new HashMap<>();

        for(int i =0;i<secretArr.length;i++){
            if(secretArr[i]==guessArr[p1]){
                A++;
            }
            p1++;
        }
        p1=0;
        System.out.print(A);
        for(int j=0;j<secretArr.length;j++){
            mapS.put(secretArr[j], mapS.getOrDefault(secretArr[j], 0) + 1);//getOrDefault(key, 0),key不存在值为0，存在为值本身
            mapG.put(guessArr[p1], mapG.getOrDefault(guessArr[p1], 0) + 1);//getOrDefault(key, 0),key不存在值为0，存在为值本身
            p1++;
        }
        for (Character key : mapG.keySet()) {
            int n1 = mapG.getOrDefault(key, 0);//getOrDefault(key, 0),key不存在值为0，存在为值本身
            int n2 = mapS.getOrDefault(key, 0);//getOrDefault(key, 0),key不存在值为0，存在为值本身
            B = B + Math.min(n1, n2);
        }
        return String.valueOf(A)+"A"+String.valueOf(B-A)+"B";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String secret = in.next();
        String gusses = in.next();
        GussesNumber gs =new GussesNumber();
        System.out.println("结果是："+gs.getHint(secret,gusses));
    }
}
