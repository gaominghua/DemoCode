package com.tjpu.thread_demo.Synchroized_Lock.DIYReentrantLock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

public class DIYReentrantLock implements Lock{

    /**
     * 锁的资源---》state：0---加锁状态 1-----未加锁状态
     */
    private volatile int state;

    /**
     * 独占模式:同一时刻只有一个线程可以持有锁，其他的线程，在未获取到锁时会被阻塞
     */
    //当前独占锁的线程
    private Thread exclusiveOwnerThread;

    /**
     * 需要两个引用维护队列
     * 1.Head 指向队列的头节点
     * 2.Tail 指向队列的尾巴节点
     */
    private Node head;
    private Node tail;

    /**
     * 阻塞的node节点会放入Fifo队列
     */
    static final class Node{
        Node prev;
        Node next;
        //封装线程本身
        Thread thread;

        public Node(Thread thread) {
            this.thread = thread;
        }

        public Node() {
        }
    }

    public int getState() {
        return state;
    }

    public Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    /**
     * 获取锁，假设当前锁被占用，则会阻塞调用者线程，直到抢占锁为止
     * 模拟公平锁
     * 情景1：线程进来发现当前state==0 这个时候抢锁
     * 情景2：线程进来发现static==1 这个时候需要将当前线程入队
     */
    @Override
    public void lock() {
        //滴哦一次获取到锁的时候将state==1
        //第n次重入设置为state=n
        acquire(1);
    }
    /**
     * 竞争资源
     * 1.尝试获取锁，成功则占用锁，且返回
     * 2.抢占锁失败，阻塞当前线程
     */
    private void acquire(int arg){
        if (!tryAcquire(arg)){
            //更复杂逻辑
           Node node = addWaiter();
            acquireQueued(node,arg);
        }

    }
    /**
     * 尝试抢占锁失败，需要做什么？
     * 1.需要将当前线程封装成node，加入到阻塞队列中
     * 2.加入阻塞队列需要将当前线程park，使线程处于挂起状态
     *
     * 唤醒后：
     * 1.检查当前node节点是否为head。next节点（head.next节点是拥有抢占权限的线程）
     * 2.抢占成
     *      成功：1.将node设置为head，将老的head=出队操作，返回u到业务逻辑层面
     *      失败：2。继续park，等待被唤醒
     *==========================================================
     * 1.添加到阻塞队列所及 addWaiter()
     * 2.竞争资源逻辑 acquireQueued()
     *
     */
        private void acquireQueued(Node node,int arg){
            //只有当前线程成功获取到锁后才会跳出自旋
            for(;;){
                //什么情况下当前node被唤醒之后可以尝试获取锁？
                //只有一种情况，当前node是head的后继节点才有这个权限。先来后到
                Node pred = node.prev;
                if (pred==head&&tryAcquire(arg)){
                    //这里面，说明当前线程竞争锁成功
                    //需要做点什么？
                    //1.设置当前head为当前线程的node
                    //2.协助原始head出堆
                    setHead(node);
                    pred.next=null;
                    return;

                }
                System.out.println("线程： "+Thread.currentThread().getName()+". 挂起");
                //park。。。
                LockSupport.park();
                System.out.println("线程： "+Thread.currentThread().getName()+". 唤醒");
            }
        }

    /**
     * 当前线程入队
     * 返回当前线程对应的node节点
     * addWaiter方法执行完毕，保证当前线程已经入队成功
     * @return
     */
    private  Node addWaiter(){
        Node newNode =new Node(Thread.currentThread());
        //如何入队？
        //1.找到newNode的前置节点
        //2/更新newNode.pre=前置节点
        //3.CAS更新tail为newNode
        //4.跟新pred.next=newNode
        //前置条件队列已经有等待node，当前node不是第一个入队node
        Node pred =tail;
        if(pred!=null){
            newNode.prev=pred;
            //这个条件成立说明当前线程成功入队
            if (compareAndSetTail(pred,newNode)){
                pred.next=newNode;
            }

        }
        //执行到这里有几种情况？
        //1.tail==null 说明这个队列是null队列
        //2.Cas 设置当前newNode为tail失败了，被其他线程抢先一步
        enq(newNode);
        return  newNode;

    }

    /**
     * 自旋入队：只有成功后才返回
     *    //1.tail==null 说明这个队列是null队列
     *    //2.Cas 设置当前newNode为tail失败了，被其他线程抢先一步
     * @param
     */
    private void enq(Node node){
        for (;;){
            //1.队列为空的情况-----得到当前线程是第一个抢占锁失败的线程
            //当前持有锁的线程并没有设置过任何node，所以作为改线程的第一个后驱节点
            //需要给当前持有锁的线程补充一个node作为head节点。
            //head节点任何时候都代表张勇锁的线程
            if(tail==null){
                //条件成立说明当前线程给当前持有锁的线程补充head成功
                if (compareAndSetHead(new Node())){
                    tail=head;

                }
            }else {
                //说明：当前队列已经有node，这是一个追加node过程
                //如何入队？
                //1.找到newNode的前置节点
                //2/更新newNode.pre=前置节点
                //3.CAS更新tail为newNode
                //4.跟新pred.next=newNode
                //前置条件队列已经有等待node，当前node不是第一个入队node
                Node pred =tail;
                if(pred!=null){
                    node.prev=pred;
                    //这个条件成立说明当前线程成功入队
                    if (compareAndSetTail(pred,node)){
                        pred.next=node;
                        //入队成功要renturn
                        return ;
                    }

                }
            }

        }
    }
    /**
     * 尝试获取锁不会阻塞线程
     * @param arg
     */
    private boolean tryAcquire(int arg){
        if (state==0){
            //当前state等于0时是否可以直接抢占锁？
            //不可以：因为模拟公平锁，则先来后到
            //条件1：!hasQueuedPredecessor取反后值为True表示当前线程前面没有等待着线程
            //条件2：可能会有多线程调用所以采用CAS，成立说明当前线程枪锁成功
            if (!hasQueuedPredecessor()&&compareAndSetstate(0,arg)) {
                //需要将exclusiveOwnerThread设置为进入if块的线程
                exclusiveOwnerThread = Thread.currentThread();
                return true;
            }
         //当前锁被占用会来到这个条件
            //条件成立说明当前线程是持锁线程，是需要返回true并且跟新state值
        }else if (Thread.currentThread()==this.exclusiveOwnerThread){
            //说明当前线程是持锁线程，需要返回true
            int c=getState();
            c=c+arg;

            //越界判断
            this.state=c;

        }
        //什么时候返回false
        //1.CAS加锁失败
        //2.state》0,当前线程不是占用线程
      return false;
    }

    /**
     * true:表示当前线程前面有等待着线程
     * false：表示当前线程前面没有其他等待线程
     *
     * 调用链
     * lock----acquire--tryacquire ----state=0时候，即当前lock属于无主状态。。
     *
     * 什么时候返回false？
     * 1.当前队列是空且
     * 2。当前线程为head.next节点线程。。。heead。next在任何时候都有权力争取lock
     * @return
     */
    private boolean hasQueuedPredecessor(){
        Node h =head;
        Node t=tail;
        Node s;

        //条件1：h！=t
        //成立说明当前线程已经有node
        //不成立：1.h==t==nnull 2.h===t===null第一个获取锁失败的线程会为当前持有锁的线程补充创建一个head节点

        //条件二: ((s=h.next)==null || s.thread!=Thread.currentThread()
        //排除几种情况
        //条件2.1：(s=h.next)==null
        // ---极端情况，第一个获取锁失败的线程，会为持锁的线程补充创建head节点，然后再自旋入队
        //   1.CAS tail() 成功了 2.pred【head】.next=node
        //其实想表打的就是：已经有head.next节点，其他节点再来到这里，需要返回true

        //条件2.2：前置条件h.next不是空，s.thread!=Thread.currentThread()
        //条件成立说明，当前线程就不是h.next节点对应线程  返回true
        //条件不成立：当前线程就是h.next节点对应线程  返回false，回头线程会竞争锁
        return h!=t && ((s=h.next)==null || s.thread!=Thread.currentThread());
    }

    /**
     * 释放锁
     */
    @Override
    public void unlock() {
        release(1);
    }

    private void release(int arg){
        //条件成立说明线程已经完全释放锁了
        //阻塞队列里面还有其他睡眠线程，需要唤醒其他线程
        if (tryRelease(arg)){
            Node head=this.head;

            //得直到有没有等待得节点？判断head.next==Null？
            if (head.next!=null){
                //公平锁，唤醒head.next节点
                unparkSuccersor(head);
            }
        }
    }

    private void unparkSuccersor(Node node){
        Node s= node.next;
        if(s!=null&&s.thread!=null){
            LockSupport.unpark(s.thread);
        }
    }
    /**
     * 完全释放锁返回true
     * @param arg
     * @return
     */
    private boolean tryRelease(int arg){
        int c =getState()-arg;
        if (getExclusiveOwnerThread()!=Thread.currentThread()){
            throw new RuntimeException("=======Must getLock=======");
        }
        //如果执行到这里？存放并发？
        //不存在并发，只有 一个线程ExclusiveOwnerThread会来到这里
        //条件成立说明当前线程持有的锁已经完全释放
        if(c==0){
            //1.ExclusiveOwnerThread置为空
            //2设置state==0

            this.exclusiveOwnerThread=null;
            this.state=c;
            return true;
        }
        this.state=c;
        return false;
    }


    public void setHead(Node node){
        this.head=node;
        node.thread=null;
        node.prev=null;
    }

    private static final Unsafe unsafe;
    private static final long stateOffset ;
    private static final long headOffset;
    private static final long tailOffset;

    static{
        try {
            Field f =Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe=(Unsafe) f.get(null);
            stateOffset=unsafe
                    .objectFieldOffset(DIYReentrantLock.class
                            .getDeclaredField("state"));
            headOffset=unsafe
                    .objectFieldOffset(DIYReentrantLock.class
                            .getDeclaredField("head"));
            tailOffset=unsafe
                    .objectFieldOffset(DIYReentrantLock.class
                            .getDeclaredField("tail"));

        }catch (Exception ex){throw new Error(ex);}
    }
    private final boolean compareAndSetHead(Node update){
        return unsafe.compareAndSwapObject(this,headOffset,null,update);
    }
    private final boolean compareAndSetTail(Node except,Node update){
        return unsafe.compareAndSwapObject(this,tailOffset,except,update);
    }
    private final boolean compareAndSetstate(int except,int update){
        return unsafe.compareAndSwapObject(this,stateOffset,except,update);
    }

}
