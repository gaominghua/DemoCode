package com.tjpu.java.TimeTask;

import org.junit.Test;

public class ThreadByTimeTask {

    public static void main(String[] args) {
        // 单位: 毫秒
        final long timeInterval = 5000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // ------- code for task to run
                    System.out.println("Hello !!");
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
