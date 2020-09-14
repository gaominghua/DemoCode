package com.tjpu.SpringBoot.Event_Listene.Manager;

import com.tjpu.SpringBoot.Event_Listene.Event.ApplicationEvent;
import com.tjpu.SpringBoot.Event_Listene.Listener.ApplicationListener;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class ListenerManager {
    static  List<ApplicationListener<?>> list =new ArrayList<>();

    public static void addListener(ApplicationListener listener){
        list.add(listener);
    }

    //发布事件
    public static void pushEvent(ApplicationEvent event){
        for (ApplicationListener applicationListener:list){
            //反射获取泛型
            Class tClas =(Class)((ParameterizedType)applicationListener.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
            if(tClas.equals(event.getClass())){//判断这个监听器是否匹配事件
                applicationListener.onEvent(event);

            }
        }

    }
}
