package com.tjpu.PatternDesign.Proxy.StaticProxy1;

/**
 * 代理模式得优势：
 * 1.可以使真实角色得操作更加纯粹，不需要去关注一些公共业务
 * 2.公共业务叫给代理角色，实现了业务得分工
 * 3.公共业务发生扩展得时候方便集中管理
 * 缺点：一个真实角色，产生一个代理列，代码量翻倍，开发效率变低；
 */
public class Proxy {
    private Host host;
    public Proxy(){

    }
    public Proxy(Host host){
        this.host=host;
    }

    public void rent(){
        host.rent();
    }

    //看房
    public  void seeHouse(){
        System.out.println("中介带你看房！！");
    }
    //收中介费
    public void fare(){
        System.out.println("收中介费!!");
    }
    //中介签合同
    public void heTong(){
        System.out.println("签租赁合同！！");
    }

}
