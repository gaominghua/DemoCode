package com.tjpu.Algorithm_Code.LeetCode;

/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 */
public class MaxScoreSightseeingPair_1014 {

    public int maxScoreSightseeingPair(int[] A) {

        int res =0;
        int maxScore = A[0]+0;
        for (int j=1;j<A.length;j++){
            res =Math.max(res,maxScore+A[j]-j);
            maxScore = Math.max(maxScore, A[j] + j);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] A= new int[]{8,1,5,2,6};
        MaxScoreSightseeingPair_1014 maxScoreSightseeingPair =new MaxScoreSightseeingPair_1014();
        System.out.println(maxScoreSightseeingPair.maxScoreSightseeingPair(A));

    }
}
