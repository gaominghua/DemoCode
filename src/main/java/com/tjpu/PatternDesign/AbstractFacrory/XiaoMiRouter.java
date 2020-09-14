package com.tjpu.PatternDesign.AbstractFacrory;

public class XiaoMiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("=====开启小米路由器======");
    }

    @Override
    public void shutdown() {
        System.out.println("=====关闭小米路由器======");
    }

    @Override
    public void openWiFi() {
        System.out.println("=====小米路由器打开WIFI======");
    }

    @Override
    public void setting() {
        System.out.println("=====小米路由器打开设置======");
    }
}
