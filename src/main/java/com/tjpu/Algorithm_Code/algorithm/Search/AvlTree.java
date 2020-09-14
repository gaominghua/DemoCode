package com.tjpu.Algorithm_Code.algorithm.Search;

public class AvlTree <T extends Comparable> {
    //定义平衡二叉树的根节点
    private AvlNode tree;

    /**
     * 计算 某一个节点的高度
     */
    private int hegiht(AvlNode node){

        return node==null?0:node.height;
    }

    /**
     * 计算AVL树的高度
     */
    public int hegiht() {
     return hegiht(tree);
    }

    /**
     * 计算两个高度的最大值
     */
    private int getMax(int h1,int h2){
        return h1>h2?h1:h2;
    }

    /**
     *采用中序遍历的方式
     */
    private void inOrder(AvlNode node){
        if (node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.getData()+"----->");
        inOrder(node.right);
        System.out.println();

    }

    @Override
    public String toString() {
       inOrder(tree);
        return "";
    }

    /**
     * LL旋转处理平衡二叉树节点
     * @param node 失衡的节点
     * @return 左旋后的根节点
     */
    public AvlNode ll(AvlNode node){

        //定义一个临时变量保存我们失衡节点的左子树
        AvlNode node_left = node.left;
        //将失衡节点的左子树的右子树作为失衡节点的左子树
        node_left = node_left.right;
        //将失衡节点作为调整后根节点的右子树
        node_left.right=node;
        //重新计算失衡节点赫旋转后根节点的高度
        node.height=getMax(hegiht(node.left),hegiht(node.right))+1;
        node.left.height=getMax(hegiht(node_left.left),hegiht(node_left.right))+1;
        return node_left;
    }

    /**
     * LL旋转处理平衡二叉树节点
     * @param node 失衡的节点
     * @return 右旋后的根节点
     */
    public AvlNode rr(AvlNode node){

        //定义一个临时变量保存我们失衡节点的左子树
        AvlNode new_root = node.right;
        node.right=new_root.left;
        new_root.left=node;
        node.height=getMax(hegiht(node.left),hegiht(node.right))+1;
        new_root.height=getMax(hegiht(new_root.left),hegiht(new_root.right))+1;

        return new_root;

    }

    /**
     *LR旋转
     */
    public AvlNode lr(AvlNode node){
        //RR旋转
        node.left =rr(node.left);
        //LL旋转
        AvlNode avlNode =ll(node);
        return avlNode;
    }

    /**
     *RL旋转
     */
    public AvlNode rl(AvlNode node){
        //RR旋转
        node.right =ll(node.right);
        //LL旋转
        AvlNode avlNode =rr(node);
        return avlNode;
    }

    /**
     * 插入数据
     * @param value
     */
    public void insert(T value){
        this.tree = insert(tree,value);
    }
    /**
     * 插入操作
     */
    private AvlNode insert(AvlNode node,T data){
        if (node==null){
            node =new AvlNode<T>(data);
        }else{
            int compared =data.compareTo(node.getData());
            if (compared>0){
                node.right=insert(node.right,data);
                if (hegiht(node.right)-hegiht(node.left)==2){
                    if (data.compareTo(node.right.getData())>0){
                        //RR旋转
                        node=this.rr(node);
                    }else{
                        node=this.rl(node);
                    }
                }
            }else if (compared<0){
                node.left=insert(node.left,data);
                if (hegiht(node.left)-hegiht(node.right)==2){
                    if (data.compareTo(node.left.getData())>0){
                        //LR旋转
                        node=this.lr(node);
                    }else{
                        //LL旋转
                        node=this.ll(node);
                    }
                }
            }else {

            }
        }
        node.height=getMax(hegiht(node.left),hegiht(node.right))+1;
        return node;
    }



    public static class AvlNode<T extends Comparable>{
        //存储数据
        private T data;
        //左子节点
        AvlNode<T> left;
        //右子节点
        AvlNode<T> right;
        //节点高度
        private int height;

        public AvlNode(T data,AvlNode left,AvlNode right,int height){
            this.data=data;
            this.left=left;
            this.right=right;
            this.height=height;
        }

        public AvlNode(T data, AvlNode<T> left, AvlNode<T> right) {
            this(data,left,right,0);
        }

        public AvlNode(T data) {
            this(data,null,null);
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public AvlNode<T> getLeft() {
            return left;
        }

        public void setLeft(AvlNode<T> left) {
            this.left = left;
        }

        public AvlNode<T> getRight() {
            return right;
        }

        public void setRight(AvlNode<T> right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }


    public static void main(String[] args) {
        AvlTree tree = new AvlTree();

        //添加节点
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        tree.insert(12);
        tree.insert(9);
        tree.insert(4);
        tree.insert(5);
        tree.insert(7);
        tree.insert(1);
        tree.insert(11);
        tree.insert(17);
        //打印结果
        System.out.println(tree);


    }
}
