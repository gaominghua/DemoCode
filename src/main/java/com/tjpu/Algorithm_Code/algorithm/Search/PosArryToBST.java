package com.tjpu.Algorithm_Code.algorithm.Search;

/**
 * 通过后续遍历序列的数组重建二叉查找树
 */
public class PosArryToBST {
    //构建一个树节点的结构
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value=value;
        }
    }


    public static Node posArryToBST1(int[] posArr){
        //从0-N-1范围
        return process1(posArr,0,posArr.length-1);
    }
    //使用后续数组从L-R范围的数字来建这棵树
    //建出的每一个节点都连好，然后返回整棵树头节点
    public static Node process1(int[] posArr,int L,int R){
        //无效范围，不需要建树，直接返回
        if (L>R){
            return null;
        }
        //有效范围L<R，建树
        //L-R范围开始建树，头节点一定是R
        Node head =new Node(posArr[R]);
        //只有一个树的情况，不需要考虑左孩子右孩子
        if (L==R){
            return head;
        }
        //L<R 不只有一个树的情况，要考虑左孩子右孩子
        int M=L-1;
        for (int i=L;i<R;i++){
            if (posArr[i]<posArr[R]){
                M=i;
            }
        }
        head.left=process1(posArr,L,M); //递归
        head.right=process1(posArr,M+1,R-1);//递归
        return head;
    }
}
