package com.tjpu.Algorithm_Code.LeetCode;

import java.util.LinkedList;

/**
 * leetcode 225
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

 */
public class QueueToStack {
    //两个队列模拟栈，其中一个始终为空作为辅助队列
    LinkedList<Integer> q1 = new LinkedList<>();
    LinkedList<Integer> q2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public QueueToStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);//向队列1中插入元素
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!q1.isEmpty()){
            while(q1.size()>1){//队列1的元素大于2时将元素都放入队列2，的到最后一个元素
                q2.offer(q1.poll());//队列1为空，将队列二
            }
            return q1.poll();//此时队列1清空

        }else{//对列1为空的情况，对列2不为空
            while(q2.size()>1){//队列1的元素大于2时将元素都放入队列2，的到最后一个元素
                q1.offer(q2.poll());//队列1为空，将队列二
            }
            return q2.poll();//此时队列2清空
        }

    }

    /** Get the top element. */
    public int top() {//和pop操作类似，只不过时检索元素不删除
        int top=0;//初始化最顶端元素
        if(!q1.isEmpty()){
            while(q1.size()>1){//队列1的元素大于2时将元素都放入队列2，的到最后一个元素
                q2.offer(q1.poll());//队列1为空，将队列二
            }
            top=q1.poll();//此时队列2清空
            q2.offer(top);

        }else{//对列1为空的情况，对列2不为空
            while(q2.size()>1){//队列1的元素大于2时将元素都放入队列2，的到最后一个元素
                q1.offer(q2.poll());//队列1为空，将队列二
            }
            top=q2.poll();//此时队列2清空
            q1.offer(top);

        }
        return top;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty()&&q2.isEmpty();
    }
}
