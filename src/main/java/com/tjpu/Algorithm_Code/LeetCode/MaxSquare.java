package com.tjpu.Algorithm_Code.LeetCode;

/**
 *
 */
public class MaxSquare {
        public int maximalSquare(char[][] matrix) {
            int row=matrix.length;
            int col=matrix[0].length;

            int[][] dp =new int[row][col];
            int res=0;

            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    //如果在边界上等于以那么dp矩阵中对应直接为1
                    if(matrix[i][j]=='1'){
                        if(i==0||j==0){
                            dp[i][j]=1;
                        }else{
                            dp[i][j]=Math.min(Math.min(dp[i-1][j],matrix[i][j-1]),dp[i-1][j-1])+1;
                        }
                        res=Math.max(res,dp[i][j]);
                    }
                }
            }
            return res*res;
        }

}
