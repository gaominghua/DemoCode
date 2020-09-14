package com.tjpu.PatternDesign.AbstractFacrory;

/**
 * 抽象产品工厂
 */
public interface AbstractProductFactory {
    //生产手机
    IphoneProduct iphoneProduct();
    //生产路由器
    IRouterProduct routerProduct();
}
