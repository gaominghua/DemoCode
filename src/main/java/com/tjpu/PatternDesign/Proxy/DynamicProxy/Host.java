package com.tjpu.PatternDesign.Proxy.DynamicProxy;

/**
 * 房东：真实角色
 */
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东要出租房子！！！");
    }
}
