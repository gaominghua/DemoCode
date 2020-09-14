package com.tjpu.Algorithm_Code.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode
 * 复杂度o（1）
 */
public class LRUCache {
    //定义一个双向链表的结构
    class ListNode{
        //key和value为int类型
        int key;
        int value;
        ListNode pre;//指向的前一个节点
        ListNode next; //当前节点的后一个节点
        //初始化构造方法
        ListNode(int key,int value){
            this.key=key;
            this.value=value;
        }

    }
    private int capacity;//缓存的容量
    private int count;//当前缓存中元素的个数
    private ListNode dummy; //定义链表头头节点为空
    private ListNode tail;//定义一个链表的尾巴节点
    private Map<Integer,ListNode> map;//定义一个hashmap结构这样查找数据复杂度o(1)

    //LRU构造方法--初始化调用
    public LRUCache(int capacity) {
        this.capacity=capacity;
        count=0;//最开始缓存中元素0个
        dummy=new ListNode(0,0);//初始化将链表头节点置空，便于获取下一个节点
        tail=dummy;
        map=new HashMap<>();
    }
    public int get(int key) {
        //判断key对应的map是否有数据，没有数据返回-1
        if(!map.containsKey(key)){
            return -1;
        }
        //如果存在值，那么这个值之前存在链表中
        ListNode node =map.get(key);//通过map快速找到node节点位置
        //如果node不在尾巴节点那么加入尾巴节点
        if(node!=tail){
            ListNode pre =node.pre;//找到node的前一个节点
            pre.next=node.next;//将node的下一个节点交给前一个节点的next指针指向
            pre.next.pre=pre;//将pre节点的next节点的pre指针指向pre(相当于原来node.next.pre=pre)
            //以上便完成了把node节点断开，下面需要将node节点加入最尾部
            addTail(node);
        }
        return node.value;
    }
    public void put(int key, int value) {
        //put插入数据，每次插入数据都需要创建一个ListNode节点
        ListNode n =new ListNode(key,value);
        //再插入节点的时候需要判断是否原来链表中存在该节点
        //如果存在
        if(map.containsKey(key)){
            //如果存在值，那么这个值之前存在链表中
            ListNode node =map.get(key);//通过map快速找到node节点位置
            //如果node不在尾巴节点那么加入尾巴节点
            if(node!=tail){
                //以下将node的位置断开
                ListNode pre =node.pre;//找到node的前一个节点
                pre.next=node.next;//将node的下一个节点交给前一个节点的next指针指向
                pre.next.pre=pre;//将pre节点的next节点的pre指针指向pre(相当于原来node.next.pre=pre)
            }else{
                //如果node节点在尾巴，需要把node节点消除，用前一个节点代替；
                tail=tail.pre;
            }
        }else{
            //如果缓存中不包含这个key
            //判断缓存容量是否够用
            if(count<capacity){
                //如果容量够用
                count++;
            }else{
                //容量不够用,移除头节点
                removeHead();
            }
        }
        addTail(n);//把node节点插入的数据加到尾巴
        map.put(key,n);//在map中标记

    }
    private void removeHead(){//移除头节点
        //因为第一节点一直是dummy,所以可以方便的通过dummy移除第一个节点
        //通过map移除这个key,value
        map.remove(dummy.next.key);
        //移除了第一个节点后需要调整，用第二个节点取代第一个节点的位置
        dummy.next=dummy.next.next;
        if(dummy.next!=null){
            dummy.next.pre=dummy;//将dummy.next也就是第二个节点的pre指向dummy
        }
        //以上便完成了删除头节点后的调整
    }
    private void addTail(ListNode node){
        //添加尾巴节点，需要tail的next指向node

        tail.next=node;
        //node的pre指针指向tail
        node.pre=tail;
        //以上完成双向调整后，将tail放到node上即
        tail=node; //此时node节点为尾巴节点

    }
    //测试代码
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
