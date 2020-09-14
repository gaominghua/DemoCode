package com.tjpu.PatternDesign.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用这个类自动生成代理类
 * 动态代理得优势：
 * 1.一个动态代理类，代理得是一个接口，一般对应得是一类业务
 */
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理得接口
    private Object target;

    public void setRent(Object target) {
        this.target = target;
    }

    //生成得到代理对象
    public Object getProxy(){
       return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
    //处理代理实例并且返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        //动态代理得本质就是使用反射机制
        Object result = method.invoke(target,args);
        return result;
    }

    //以下主要是存放公共的业务
    //看房
    public  void seeHouse(){
        System.out.println("中介带你看房！！");
    }
    //收中介费
    public void fare(){
        System.out.println("收中介费!!");
    }
    //日志方法
    public void log(String msg){
        System.out.println("使用了"+msg+"方法！");
    }
}
