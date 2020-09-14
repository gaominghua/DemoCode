package com.tjpu.thread_demo.Thread_Runnable_Callable;

import java.util.concurrent.*;

/**
 *模拟线程Callable案例
 */
public class  Thread_Callable_Race implements Callable<Boolean> {

    //胜利者
    private static String winner;

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i <= 1000; i++) {
            //判断比赛是否结束
            boolean flag =gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"---->跑了"+i+"步");
        }

        return true;
    }
    //判断比赛是否结束
    private boolean gameOver(int steps){
        //判断是否有胜利者
        if(winner!=null){
            return true;
        }{
            if (steps>=1000){
                winner = Thread.currentThread().getName();
                System.out.println("winner is :"+winner);
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread_Callable_Race t1 = new Thread_Callable_Race();
        Thread_Callable_Race t2 = new Thread_Callable_Race();
        Thread_Callable_Race t3 = new Thread_Callable_Race();

        //创建执行服务
        ExecutorService executorService  = Executors.newFixedThreadPool(3);
        //提交执行任务

        Future<Boolean> future1 = executorService.submit(t1);
        Future<Boolean> future2 = executorService.submit(t2);
        Future<Boolean> future3 = executorService.submit(t3);

        //获取执行结果
        boolean rs1=future1.get();
        boolean rs2=future2.get();
        boolean rs3=future3.get();
        System.out.println("结果1："+rs1);
        System.out.println("结果1："+rs2);
        System.out.println("结果1："+rs3);

        //关闭服务
        executorService.shutdown();
    }


}
