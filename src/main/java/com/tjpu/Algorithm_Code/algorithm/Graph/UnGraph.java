package com.tjpu.Algorithm_Code.algorithm.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 采用邻接表的方式存储无向图
 */
public  class UnGraph {
    /**
     * 标识图中顶点的个数
     */
    private int points;
    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adjacencyList;

    public UnGraph(int points) {
        this.points = points;
        //初始化数组
        adjacencyList=new LinkedList[this.points];
        //初始化数组中每个槽位上的链表
        for(int i=0;i<this.points;i++){
            adjacencyList[i]=new LinkedList<Integer>();
        }
    }
    /**
     * 向图中添加顶点
     */
    public void addPoint(int s,int t){
        adjacencyList[s].add(t);
        adjacencyList[t].add(s);
    }

    /**
     * 广度优先搜索,s--起始顶点，t----目标顶点
     */
    public void  bfs(int s,int t){
        if (s==t){
            return;
        }
        /**
         * 定义一个boolen数组用来记录顶点是否呗访问过
         */
        boolean[] visited = new boolean[this.points];
        //起始顶点已经呗访问设置为true
        visited[s]=true;
        //定义一个队列存储已经被访问过的顶点但是还有相邻顶点未被访问的
        Queue<Integer> queue =new LinkedList<Integer>();
        queue.add(s);
        /**
         * 定义一个数组用来存储s到t的线路
         */
        int[] prev =new int[this.points];
        //初始化所有访问线路为-1
        for (int i=0;i<prev.length;i++){
            prev[i]=-1;
        }
        //循环访问队列中没有被访问的顶点
        while(!queue.isEmpty()){
            //取出访问过的但是有相邻顶点的顶点
            Integer p = queue.poll();
            //遍历这个顶点的相邻顶点
            for (int j=0;j<adjacencyList[p].size();j++){
                //取出相邻顶点
                Integer p_edge = adjacencyList[p].get(j);
                //如果相邻顶点未被访问过
                if (!visited[p_edge]){
                    //记录访问路线
                    prev[p_edge] = p;
                    //如果该顶点与t相等这个时候打印访问路线
                    if (p_edge==t){
                        //TODO
                        print(prev,s,t);
                        return;
                    }
                    //否则标记p为已经访问过的顶点
                    visited[p]=true;
                    //相邻顶点存如队列
                    queue.add(p_edge);
                }
            }

        }

    }

    /**
     * 打印从s-t线路的方法
     */
    public void print(int[] prev ,int s,int t){
        if (prev[t]!=-1&&s!=t){
            print(prev,s,prev[t]);
        }
        System.out.println(t+">>>>>");
    }


    /**
     * 标记我们是否找到目标顶点t
     */
    private boolean found =false;

    /**
     * 深度度优先搜索,s--起始顶点，t----目标顶点
     */
    public void dfs(int s,int t){
        if (s==t){
            return;
        }
        boolean[] visited = new boolean[this.points];
        //起始顶点已经呗访问设置为true
        visited[s]=true;
        //定义一个数组记录我们从原定点到目标顶点的线路
        int[] prev = new int[this.points];
        for (int i=0;i<prev.length;i++){
            prev[i]=-1;
        }
        //递归调用
        returnDFS(s,t,visited,prev);
        //打印线路
        print(prev,s,t);
    }

    /**
     * 查找顶点point到目标顶点的线路
     * @param points 顶点
     * @param target 目标顶点
     * @param visited 访问过的顶点
     * @param prev 顶点的线路的数组
     */
    private void returnDFS(int points,int target,boolean[] visited,int[] prev){
        if (found){
            return;
        }
        //标记当前顶点已经被访问过
        visited[points]=true;
        //如果当前顶点就是目标顶点
        if (points==target){
            found=true;
            return;
        }
        //获取与当前顶点相连接的所有顶点
        for(int j=0;j<adjacencyList[points].size();j++){
            //获取与顶点point相邻的顶点
            Integer p_connect=adjacencyList[points].get(j);
            if (!visited[p_connect]){
                //记录访问路线
                prev[p_connect] = points;
                //递归寻找
                returnDFS(p_connect,target,visited,prev);
            }

        }


    }




    public static void main(String[] args) {

        UnGraph unGraph = new UnGraph(8);
        unGraph.addPoint(0,1);
        unGraph.addPoint(0,3);
        unGraph.addPoint(1,2);
        unGraph.addPoint(1,4);
        unGraph.addPoint(2,5);
        unGraph.addPoint(3,4);
        unGraph.addPoint(4,5);
        unGraph.addPoint(4,6);
        unGraph.addPoint(6,7);
        unGraph.addPoint(7,5);
        unGraph.dfs(0,6);
        //System.out.println(unGraph);

    }
}
