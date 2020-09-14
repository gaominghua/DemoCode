package com.tjpu.thread_demo.ContainerUnSafe_Safe;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合对象
public class Thread_UnSafeList {

    public static void main(String[] args) {
        List<String> list =new ArrayList<String>();
        for (int i = 1; i <= 1000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }


}
