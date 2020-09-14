package com.tjpu.Algorithm_Code.LeetCode;

import org.apache.hadoop.hdfs.tools.DFSAdmin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * leetcode 46
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 采用深度优先搜索实现
 */
public class Permute {
    //定义一个结果集存放最终结果
    List<List<Integer>> totalRes =new ArrayList<>();
    public List<List<Integer>>  permute(int[] nums){
        List<Integer> subRes = new ArrayList<>();
        boolean[] visited =new boolean[nums.length];//定义一个visited数组用于回溯的时候元素是否被判断过
        DFS(nums,subRes,visited);
        return totalRes;

    }

    private List<Integer> DFS(int[] nums, List<Integer> subRes, boolean[] visited) {
        //边界条件合适深度递归的时候结束
        //当子集合元素和num集合元素个数相等的时候不需要再进行递归，直接加入结果集中返回
        if(subRes.size() == nums.length){
            //此处需要注意从新new一个数组添加否则结果回出现[][][][]
            //因为subRes在整个过程中一直在操作，当回溯的最开始的时候便为空了
            totalRes.add(new ArrayList<>(subRes));
        }
        //不满足边界条件，一直深度搜索
        for (int i=0;i<nums.length;i++){
            //定义一个临时变量存放nums的元素
             int temp = nums[i];
             if (visited[i]!=true){//如果nums中的元素与visited 对应，如果某个元素未被访问过标记false
                //未被访问过，添加访问标记，加入subRes中
                 visited[i]=true;
                 subRes.add(temp);
                 //继续向下深度搜索
                 DFS(nums,subRes,visited);
                 //当搜索到最底层的时候，开始进行回溯操作
                 //此时需要将sub的长度逐渐减少1,每次移除最后的元素
                 subRes.remove(subRes.size()-1);
                 //移除后的节点就是未被访问过的因此从新标记
                 visited[i]=false;
             }
        }
        return subRes;
    }

    public static void main(String[] args) {
        System.out.println("请输入数组的元素：--------------");
        Scanner in =new Scanner(System.in);
        String line =in.nextLine();
        String[] strArray = line.split(" ");
        int[] nums =new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            nums[i]=Integer.parseInt(strArray[i]);

        }
        System.out.println("输入的数组是："+ Arrays.toString(nums));


        Permute permute =new Permute();
        List<List<Integer>> totalRes = permute.permute(nums);
        System.out.println(totalRes.toString());
    }
}

