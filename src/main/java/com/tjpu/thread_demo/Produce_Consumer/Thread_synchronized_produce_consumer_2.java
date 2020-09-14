package com.tjpu.thread_demo.Produce_Consumer;

//测试生产者，消费者问题2：信号灯法，通常通过标志位解决

public class Thread_synchronized_produce_consumer_2 {
    public static void main(String[] args) {

        TV tv = new TV();

        new player(tv).start();
        new Watcher(tv).start();
    }

}


//生产者---演员
class player extends Thread{
    TV tv;
    public player(TV tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                this.tv.play("快乐大本营播放中");
            }else {
                this.tv.play("抖音：记录美好生活");
            }
        }
    }
}


//消费者--->观众
class Watcher extends Thread {
    TV tv;
    public Watcher(TV tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
          tv.watch();
        }
    }
}

//产品------节目

class TV{
    //演员表演，观众等待
    //观众观看得时候，演员等待

    String voice;//表演得节目
    boolean flag =true; //true演员表演
    //表演
    public synchronized void play(String voice){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了："+voice);
        //通知观众观看
        this.notifyAll();//通知唤醒
        this.voice=voice;
        this.flag=!this.flag;
    }

    //观看
    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了："+voice);
        //通知演员表演
        this.notifyAll();//通知唤醒
        this.flag=!this.flag;
    }

}