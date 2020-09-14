package com.tjpu.PatternDesign.AbstractFacrory;

public class HuaweiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("=====开启华为路由器======");
    }

    @Override
    public void shutdown() {
        System.out.println("=====关闭华为路由器======");
    }

    @Override
    public void openWiFi() {
        System.out.println("=====华为路由器打开WIFI======");
    }

    @Override
    public void setting() {
        System.out.println("=====华为路由器打开设置======");
    }
}
