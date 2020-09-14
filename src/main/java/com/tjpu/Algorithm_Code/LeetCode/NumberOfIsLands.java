package com.tjpu.Algorithm_Code.LeetCode;

/**
 * leetcode-200
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */
public class NumberOfIsLands {
    private int result=0;
    private int m;//矩阵m行
    private int n; //矩阵n列

    public int numIslands(char[][] grid){
        if (grid.length==0||grid[0].length==0) return 0;
        m=grid.length;
        n=grid[0].length;
        //遍历矩阵每行
        for (int i=0;i<m;i++){
            //遍历矩阵每列
            for (int j=0;j<n;j++){
                if (grid[i][j]=='0') continue;
                dfs(grid,i,j);//如果该位置不是0即是1那么深度优先搜索遍历
                result++;//岛屿加一个
            }
        }
        return result;
    }
    public void dfs(char[][] grid,int i,int j){
        if (i<0||j<0||i>=m||j>=n) return;
        if (grid[i][j]=='0') return;
        grid[i][j]='0';//每次得到将1变成0 这样在 下次遍历的时候就不用考虑了
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }


    public static void main(String[] args) {
        NumberOfIsLands numberOfIsLands =new NumberOfIsLands();
        char[][] Grid={
                {'1','1','0'},
                {'1','1','0'},
                {'0','0','1'},
        };
        System.out.println("岛屿的个数有："+numberOfIsLands.numIslands(Grid));
    }
}
