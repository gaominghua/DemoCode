package com.tjpu.Algorithm_Code.algorithm.Search;

/**
 * 定义一个二叉查找树基础数据结构:查找、插入、删除
 */
public class BinarySearchTree {
    /**
     * 定义一个父节点
     */
    Node paraent;
    //树节点的数据结构
    public static class Node{
        //定义我们的数据值
        private int value;
        //左子节点指针；
        private  Node left;
        //右子节点指针；
        private  Node right;

        //初始构造方法
        protected Node(Node left,int value,Node right){
            this.left=left;
            this.value=value;
            this.right=right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    /**
     * 删除二叉查找树中某个节点
     */
    public void delete(int value){
        //记录要删除的节点
        Node p =paraent;
        //记录要删除节点的父节点
        Node p_parent=null;
        //找到要删除的元素及其父元素
        while (p!=null){
            if (p.value>value){
                p_parent=p;
                p=p.left;
            }else if (p.value<value){
                p_parent=p;
                p=p.right;
            }else {
                break;
            }
        }
        if (p==null){
            return;
        }
        //要删除的节点有两个子节点
        if (p.left!=null && p.right!=null){
            Node rTree=p.right;
            Node rTree_p = p;
            while(rTree.left!=null){
                rTree_p=rTree;
                rTree=rTree.left;
            }
            //用右子树中的最小节点替换要删除节点的位置
            p.value=rTree.value;
            p=rTree;
            p_parent=rTree_p;
        }
        //要删除的节点是叶子节点或者只有一个叶子节点的子节点
        Node child =null;
        if (p.right!=null){
            child=p.right;
        }else if (p.left!=null){
            child=p.left;
        }else {
            child=null;
        }
        //执行删除操作
        if(p_parent==null){
            paraent=child;
        }else if(p_parent.left==p){
            p_parent.left=child;
        }else {
            p_parent.right=child;
        }
    }

    /**
     * 查找代码//二叉树查找数据
     * @param value
     * @return
     */

    public Node find(int value){
        while(paraent!=null){
            if (paraent.value>value){
                paraent=paraent.left;
            }else if (paraent.value<value){
                paraent=paraent.right;
            }else {
                return paraent;
            }
        }
        return paraent;
    }
    //向二叉树插入数据
    public boolean put(int value){
        if (paraent==null){
            //当前是空树需要创建一个节点
            paraent=crateNode(value);
            return true;
        }
        Node pt =paraent;
        while (pt!=null){
            //当前我们要插入数据因该存储在左子树上
            if(pt.value>value){
                if(pt.left==null){
                    pt.left=crateNode(value);
                    return true;
                }
                pt=pt.left;
            }else if(pt.value<value) {//否则需要向右子树插入
                if(pt.right==null){
                    pt.right=crateNode(value);
                    return true;
                }
                pt=pt.right;
            }
        }
        return false;
    }

    //构造一个没有左右子树孩子节点
    private Node crateNode(int value){
        return  new Node(null,value,null);
    }
    //构造一个有左右子树的节点
    private Node crateNode(Node left,int value,Node right){
        return  new Node(left,value,right);
    }

    public static void main(String[] args) {
        BinarySearchTree bsTree = new BinarySearchTree();
        bsTree.put(16);
        bsTree.put(14);
        bsTree.put(35);
        bsTree.put(12);
        bsTree.put(15);
        bsTree.put(25);
        bsTree.put(40);
        bsTree.put(10);
        bsTree.put(20);
        bsTree.put(27);
        bsTree.put(38);
        bsTree.put(41);
        bsTree.put(26);
        bsTree.put(30);
        bsTree.put(39);
//
//        Node node = bsTree.find(8);
//        System.out.println("值未8的节点信息："+node+"---"+node.value);
        bsTree.delete(10);
        System.out.println(bsTree);

    }
}
