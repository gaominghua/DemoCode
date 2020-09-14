package com.tjpu.PatternDesign.AbstractFacrory;

/**
 * 小米的工厂
 */
public class XiaoMiFactory  implements AbstractProductFactory{
    @Override
    public IphoneProduct iphoneProduct() {
        return new XiaoMiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new XiaoMiRouter();
    }
}
