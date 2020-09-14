package com.tjpu.PatternDesign.SinglePattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/***
 * 懒汉式单例模式：需要的时候才new对象
 */

class LazyMan1 {
    //定义一个私有变量防止单例被破坏
    private static  boolean flag=false;


    private LazyMan1(){
//        System.out.println(Thread.currentThread().getName()+"OK");
        synchronized (LazyMan1.class){
            if (LazyMan1!=null){
                throw  new RuntimeException("不要试图通过反射破坏异常");
            }
        }
    }

    private volatile static LazyMan1 LazyMan1;//为了保证避免指令重排需要加上volatile

    //双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static LazyMan1 getInstance(){
        if (LazyMan1==null){
            synchronized (LazyMan1.class){
                if (LazyMan1==null){
                    LazyMan1 = new LazyMan1();//不是一个原子性操作，会执行以下步骤
                    /***
                     * 1.分配内存空间
                     * 2.执行构造方法，初始对象
                     * 3.把这个对象指向这个空间
                     * 以上可能会发生指令重排，所以需要在layMan1上加volatile
                     */
                }
            }
        }
        return  LazyMan1;
    }




    //反射破坏单例模式
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        SinglePattern_LazyMan_demo instance = SinglePattern_LazyMan_demo.getInstance();

        //通过反射获取字段来破坏
        Field flag = LazyMan1.class.getDeclaredField("flag");
        flag.setAccessible(true);

        //反射通过无参构造方法破坏单例模式
        Constructor<LazyMan1> declaredConstructors
                = LazyMan1.class.getDeclaredConstructor(null);
        declaredConstructors.setAccessible(true);

        LazyMan1 instance = declaredConstructors.newInstance();
        flag.set(instance,false);
        LazyMan1 instance2 = declaredConstructors.newInstance();

        System.out.println(instance);
        System.out.println(instance2);

    }
}
