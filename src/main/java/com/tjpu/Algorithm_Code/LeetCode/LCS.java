package com.tjpu.Algorithm_Code.LeetCode;

import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 * 输入：abcda 输出：2
 * 输入：google 输出：2
 *        0    1    2     3    4    5
 *            a    b    c      d    a
 * 0      0   0     0    0     0    0
 * 1   a  0   1    1     1     1    2
 * 2   d  0   1    1     1     2    2
 * 3   c  0   1    1     2     2    2
 * 4   b  0   1    2     2     2    2
 * 5   a  0   2    2     2     2    3
 *
 * 最终结果5-3=2
 */
public class LCS {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String s1 = sc.next();
                String s2 = new StringBuilder(s1).reverse().toString();
                int[][] dp = new int[s1.length() + 1][s2.length() + 1];
                for (int i = 1; i < dp.length; i ++ ) {
                    for (int j = 1; j < dp[0].length; j ++ ) {
                        dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
                System.out.println(s1.length() - dp[s1.length()][s2.length()]);
            }
        }


}
