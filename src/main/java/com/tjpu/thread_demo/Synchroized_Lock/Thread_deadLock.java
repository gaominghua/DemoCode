package com.tjpu.thread_demo.Synchroized_Lock;


//死锁由多个线程户向抱着对方需要的资源，然后形成僵持
public class Thread_deadLock {
    public static void main(String[] args) {
        Makeup girl1= new Makeup(0,"girl1");
        Makeup girl2= new Makeup(1,"girl2");

        girl1.start();
        girl2.start();
    }

}


//口红
class LipStick{

}

//镜子
class Mirror{

}

class Makeup extends Thread{

    //需要的资源只有一个份
    static LipStick lipStick= new LipStick();
    static Mirror mirror= new Mirror();

    int choice;//选择
    String girlName;//人名

    Makeup(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;

    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice==0){
            synchronized (lipStick){//获得口红的锁
                System.out.println(Thread.currentThread().getName()+"获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){//一秒钟后获得镜子的锁
                    System.out.println(Thread.currentThread().getName()+"获得镜子的锁");
                }
            }
        }else {
            synchronized (mirror){//获得镜子的锁
                System.out.println(Thread.currentThread().getName()+"获得镜子的锁");
                Thread.sleep(2000);
                synchronized (lipStick){//一秒钟后获口红得的锁
                    System.out.println(Thread.currentThread().getName()+"获得口红的锁");
                }
            }
        }
    }

    //以下代码可以解决上诉死锁问题，只需要让每个人持有1把锁即可
//    private void makeup() throws InterruptedException {
//        if (choice==0){
//            synchronized (lipStick){//获得口红的锁
//                System.out.println(Thread.currentThread().getName()+"获得口红的锁");
//                Thread.sleep(1000);
//            }
//            synchronized (mirror){//一秒钟后获得镜子的锁
//                System.out.println(Thread.currentThread().getName()+"获得镜子的锁");
//            }
//        }else {
//            synchronized (mirror){//获得镜子的锁
//                System.out.println(Thread.currentThread().getName()+"获得镜子的锁");
//                Thread.sleep(2000);
//
//            }
//            synchronized (lipStick){//一秒钟后获口红得的锁
//                System.out.println(Thread.currentThread().getName()+"获得口红的锁");
//            }
//        }
//    }
}