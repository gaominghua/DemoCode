package com.tjpu.SpringBoot.Event_Listene.Util;

import com.tjpu.SpringBoot.Event_Listene.Event.FileUpLoadEvent;
import com.tjpu.SpringBoot.Event_Listene.Listener.FileUpLoadListener;
import com.tjpu.SpringBoot.Event_Listene.Manager.ListenerManager;

import java.io.*;

public class FileUtil {
    private static int READ_SIZE=100;


    public static void  fileWrite(InputStream is, OutputStream os) throws IOException {
        BufferedInputStream bis =new BufferedInputStream(is);
        BufferedOutputStream bos=new BufferedOutputStream(os);

        int fileSize=is.available();
        int readSize=0;//总共读取得大小
        byte[] b =new byte[READ_SIZE];
        boolean flag =true;
        while(flag){
            if (fileSize<READ_SIZE){
                byte[] bytes =new byte[fileSize];
                bis.read(bytes);
                bos.write(bytes);
                readSize=fileSize;
                flag=false;
            }else if(fileSize<readSize+READ_SIZE){//当时最后一次读得时候
                byte[] bytes =new byte[fileSize-readSize];
                readSize=fileSize;
                bis.read(bytes);
                bos.write(bytes);
                flag=false;
            }else{
                bis.read(b);
                readSize+=READ_SIZE;
                bos.write(b);
            }
         ListenerManager.pushEvent(new FileUpLoadEvent(fileSize,readSize));
        }
        bis.close();
        bos.close();


    }

    public static void main(String[] args) throws IOException {

        ListenerManager.addListener(new FileUpLoadListener());

        File file =new File("h://写测试文件.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        fileWrite(new FileInputStream(new File("h://读测试.txt")), new FileOutputStream(file));
    }
}
