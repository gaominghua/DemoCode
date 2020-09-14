package com.tjpu.PatternDesign.AbstractFacrory;
//路由器产品接口
public interface IRouterProduct {
    void start();
    void shutdown();
    void openWiFi();
    void setting();
}
