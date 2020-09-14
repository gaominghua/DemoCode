package com.tjpu.SpringBoot.Event_Listene.Listener;

import com.tjpu.SpringBoot.Event_Listene.Event.ApplicationEvent;
import com.tjpu.SpringBoot.Event_Listene.Event.FileUpLoadEvent;

public class FileUpLoadListener implements ApplicationListener<FileUpLoadEvent> {


    @Override
    public void onEvent(FileUpLoadEvent event) {
        double i1 =event.getFileSize();
        double d=event.getReadSize()/i1;
        System.out.println("当前文件上传的进度------->"+d*100+"%");
    }
}
