package com.tjpu.SpringBoot.Event_Listene.Listener;

import com.tjpu.SpringBoot.Event_Listene.Event.ApplicationEvent;

public interface ApplicationListener<E extends ApplicationEvent> {
    void onEvent(E e);
}
