package com.tjpu.PatternDesign.Proxy.DynamicProxy;

import com.tjpu.PatternDesign.Proxy.StaticProxy2.UserService;
import com.tjpu.PatternDesign.Proxy.StaticProxy2.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色--房东
        UserServiceImpl userService =new UserServiceImpl();
        //代理角色
        ProxyInvocationHandler pih =new ProxyInvocationHandler();
        //通过调用程序处理角色来处理要调用得接口对象;
        pih.setRent(userService);

        UserService  proxy = (UserService) pih.getProxy();
        proxy.add();


    }
}
