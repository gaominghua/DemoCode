package com.tjpu.PatternDesign.Proxy.StaticProxy1;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        //代理,代理角色一般右一些附属操作
        //例如：签合同、收中介费等
        Proxy proxy =new Proxy(host);

        //不需要直接面对房东，直接找中介
        proxy.rent();
    }
}
