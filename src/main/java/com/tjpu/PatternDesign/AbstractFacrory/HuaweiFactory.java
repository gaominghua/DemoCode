package com.tjpu.PatternDesign.AbstractFacrory;

/**
 * 华为的工厂
 */
public class  HuaweiFactory implements AbstractProductFactory {
    @Override
    public IphoneProduct iphoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new HuaweiRouter();
    }
}
