package com.tjpu.Algorithm_Code.algorithm.DP;

/**
 * 钢管切割问题
 */
public class CutSteeBar {
    /**
     *
     * @param p 钢条长度赫价格对应
     * @param n 钢条的长度
     * @return
     */
    public static int cut(int[] p,int n){
        //钢管长度为0的时候不需要切割，价格必然为0
        if (n==0) {
            return 0;
        }
        int q =Integer.MIN_VALUE;
        for (int i=1;i<n;i++){
            q=Math.max(q,p[i-1]+cut(p,n-i));
        }
        return q;
    }
}
