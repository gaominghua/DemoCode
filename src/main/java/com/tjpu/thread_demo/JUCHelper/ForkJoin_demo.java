package com.tjpu.thread_demo.JUCHelper;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/***
 * 分支合并，计算合并任务
 * //如何使用forkJoin
 * 1.需要forkjoinPool，通过它来执行
 * 2.计算任务 forkjoinpool.execute()
 * 3.计算类要继承forkjoin
 */
public class ForkJoin_demo  extends RecursiveTask<Long> {

    private long start;
    private long end;



    //临界值
    private long temp=10000L;

    public ForkJoin_demo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    //计算方法
    @Override
    protected Long compute() {

        if((end-start)<temp){

            Long sum =0L;
            for (Long i = start; i <=end; i++) {
                sum+=i;
            }
            //System.out.println(sum);
            return sum;
        }else{
            //分支合并计算forkjoin //递归
           long middle = (start+end)/2; //中间值
            ForkJoin_demo task1 = new ForkJoin_demo(start,middle);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoin_demo task2 = new ForkJoin_demo(middle+1,end);
            task2.fork();//拆分任务，把任务压入线程队列

            return task1.join()+task2.join();


        }

    }
}

class test{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
            test2();
    }

    //普通程序员做法
    public static void test1(){
        long start =System.currentTimeMillis();

        Long sum =0L;
        for (Long i = 1L; i <=10_0000_0000; i++) {
            sum+=i;
        }

        long end =System.currentTimeMillis();
        System.out.println("Sum="+sum+"时间"+(end-start));
    }

    //中等程序员做法,会使用forkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start =System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task =new ForkJoin_demo(0L,10_0000_0000);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task); //提交任务,有结果
        Long sum = submit.get();

        long end =System.currentTimeMillis();
        System.out.println("Sum="+sum+"时间"+(end-start));
    }

    //高级程序员做法,staram 并行流计算
    public static void test3(){
        long start =System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L,10_0000_0000).parallel().reduce(0,Long::sum);
        long end =System.currentTimeMillis();
        System.out.println("Sum="+sum+"时间"+(end-start));
    }

}
