package com.tjpu.PatternDesign.AbstractFacrory;

public class TestClient {
    public static void main(String[] args) {
        System.out.println("=========================小米系列产品===============");
        XiaoMiFactory xiaoMiFactory =new XiaoMiFactory();
        IphoneProduct iphoneProduct = xiaoMiFactory.iphoneProduct();
        iphoneProduct.callup();
        iphoneProduct.sendSMS();

        IRouterProduct iRouterProduct = xiaoMiFactory.routerProduct();
        iphoneProduct.start();
        iRouterProduct.openWiFi();

        System.out.println("=========================华为系列产品===============");
        HuaweiFactory huaweiFactory =new HuaweiFactory();
        IphoneProduct iphoneProduct1 = huaweiFactory.iphoneProduct();
        iphoneProduct1.callup();
        iphoneProduct1.sendSMS();

        IRouterProduct iRouterProduct1 = huaweiFactory.routerProduct();
        iphoneProduct1.start();
        iRouterProduct1.openWiFi();
    }
}
