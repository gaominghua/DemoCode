package com.tjpu.thread_demo.Synchroized_Lock;

public class Thread_unlock_bank {
    public static void main(String[] args) {
        //账户
        Account account =new Account(100,"结婚基金");
        Drawing you = new Drawing(account,50,"男方--");
        Drawing girlFriend = new Drawing(account,100,"女方--");

        you.start();
        girlFriend.start();
    }
}


//账户
class Account{
    int money;//余额
    String name;//卡名

    public  Account(int money,String name){
        this.money=money;
        this.name=name;
    }
}


//银行模拟取款
class Drawing extends Thread{
    Account account;//账户
    int drawingMongey; //取了多少钱
    int nowMoney;//目前手里的钱

    public Drawing(Account account,int drawingMongey,String name){
        super(name);
        this.account=account;
        this.drawingMongey=drawingMongey;

    }

    //取钱
    @Override
    public void run() {
        //判断有没有钱
        if(account.money-drawingMongey<0){
            System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
            return;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //卡里的余额
        account.money=account.money-drawingMongey;
        //手里的钱
        nowMoney=nowMoney+drawingMongey;
        System.out.println(account.name+"余额为："+account.money);
        System.out.println(this.getName()+"手里的钱："+nowMoney);
    }
}
