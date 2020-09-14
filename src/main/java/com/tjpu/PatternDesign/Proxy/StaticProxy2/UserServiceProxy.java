package com.tjpu.PatternDesign.Proxy.StaticProxy2;
/**
 * 代理模式得优势：
 * 1.可以使真实角色得操作更加纯粹，不需要去关注一些公共业务
 * 2.公共业务叫给代理角色，实现了业务得分工
 * 3.公共业务发生扩展得时候方便集中管理
 * 缺点：一个真实角色，产生一个代理列，代码量翻倍，开发效率变低；
 */
public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    //日志方法
    public void log(String msg){
        System.out.println("使用了"+msg+"方法！");
    }
}
