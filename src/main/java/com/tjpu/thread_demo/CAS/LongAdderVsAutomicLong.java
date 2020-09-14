package com.tjpu.thread_demo.CAS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

public class LongAdderVsAutomicLong {
    public static void main(String[] args) {
        testAtomicLongVsLongAdder(1,10000000);
        testAtomicLongVsLongAdder(10,10000000);
        testAtomicLongVsLongAdder(20,10000000);
        testAtomicLongVsLongAdder(50,10000000);
    }
    static void testAtomicLongVsLongAdder(final int threadCount,final int times){
        try {
            System.out.println("threadCount: "+threadCount+" ,times: "+times);
            long start1=System.currentTimeMillis();
            testLongAdder(threadCount,times);
            System.out.println("LongAdder 耗时： "+(System.currentTimeMillis()-start1));
            long start2 =System.currentTimeMillis();
            testAutomicLong(threadCount,times);
            System.out.println("AutomicLong 耗时： "+(System.currentTimeMillis()-start2));
//            long start3 =System.currentTimeMillis();
//            testAccumulate(threadCount,times);
//            System.out.println("LongAccumulator 耗时： "+(System.currentTimeMillis()-start3));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

//    private static void testAccumulate(int threadCount, int times) throws InterruptedException {
//        LongBinaryOperator longBinaryOperator = (x, y) -> x + y;
//        LongAccumulator longAccumulator = new LongAccumulator(longBinaryOperator,0L);
//        List<Thread> list =new ArrayList<>();
//        for (int i = 0; i < threadCount; i++) {
//            list.add(new Thread(()->{
//                for (int i1 = 0; i1 < times; i1++) {
//                    longAccumulator.accumulate(1);
//                }
//            }));
//        }
//        for (Thread thread :list){
//            thread.start();
//        }
//        for (Thread thread:list){
//            thread.join();
//        }
//    }

    private static void testAutomicLong(int threadCount, int times) throws InterruptedException {
        AtomicLong atomicLong =new AtomicLong();
        List<Thread> list =new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            list.add(new Thread(()->{
                for (int i1 = 0; i1 < times; i1++) {
                    atomicLong.incrementAndGet();
                }
            }));
        }
        for (Thread thread :list){
            thread.start();
        }
        for (Thread thread:list){
            thread.join();
        }

    }

    private static void testLongAdder(int threadCount, int times) throws InterruptedException {
        LongAdder longAdder =new LongAdder();
        List<Thread> list =new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            list.add(new Thread(()->{
                for (int i1 = 0; i1 < times; i1++) {
                    longAdder.add(1);
                }
            }));
        }
        for (Thread thread :list){
            thread.start();
        }
        for (Thread thread:list){
            thread.join();
        }
    }
}
