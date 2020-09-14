package com.tjpu.Algorithm_Code.LeetCode;

import java.util.Stack;

/**
 * 通过链表的方式存取栈的数据
 */
class MinStack {
    //定义一个链表的数组结构，存放当前值value、最小值、下一个指针
    class StackNode{
        int min;
        int value;
        StackNode next;
        StackNode(int min,int value){
            this.min=min;
            this.value=value;
            next=null;//初始时候为空，切记
        }
    }

    StackNode head;
    public void push(int x) {
        if(head==null){
            head =new StackNode(x,x);//当head节点为空的话讲push的值放入头节点
        }else{
            //当前值和之前头结点的最小值较小的做为当前的 minz，这么头节点每次保存的总是最小值
            StackNode node = new StackNode(Math.min(head.min,x),x);
            //如果头节点不为空那么将新插入的节点置换为头节点
            node.next=head;
            head=node;
        }

    }

    public void pop() {
        if(head!=null){
            head=head.next;//如果有节点不为空，将头节点的下一个节点置为头节点
        }
    }

    public int top() {
        if(head!=null) return head.value;//如果头节点不为空，将头节点的value返回即可
        return -1;

    }

    public int getMin() {
        if(head!=null) return head.min;//如果头节点不为空，只需要返回头节点的min即可
        return -1;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

/**
 * 两个栈实现最小栈，一个栈存取数据，另外一个存放最小的值
 */
class MinStack2 {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            int top = minStack.peek();
            //小于的时候才入栈
            if (x <= top) {
                minStack.push(x);
            }
        }else{
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();

        int top = minStack.peek();
        //等于的时候再出栈
        if (pop == top) {
            minStack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack2 minStack2 = new MinStack2();
        minStack2.push(-2);
        minStack2.push(0);
        minStack2.push(-3);
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.top());
        System.out.println(minStack2.getMin());
    }
}
