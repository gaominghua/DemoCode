package com.tjpu.PatternDesign.Proxy.StaticProxy2;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl  userService =new UserServiceImpl();

        //在不改变原有代码上添加一条信息，使用代理角色
        //不该便原有得代码，扩展代码
        UserServiceProxy proxy =new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.add();

    }
}
