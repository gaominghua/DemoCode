package com.tjpu.Socket.NioDemo.Demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *capacity： 最大容量，它永远不可能为负数，并且是不会变化的
 *limit：  限制，它永远不可能为负数，并且不会大于capacity
 *position：下一个读或写的位置，它永远不可能为负数，并且不会大于limit
 */
public class ReadWriteDemo {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream=new FileOutputStream("src/main/java/com/tjpu/Socket/NioDemo/File/Write.txt");
        FileInputStream fileInputStream=new FileInputStream("src/main/java/com/tjpu/Socket/NioDemo/File/Read.txt");

        FileChannel channelRead = fileInputStream.getChannel();
        FileChannel channelWrite = fileOutputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(100);
       while (true){
           byteBuffer.clear();//重新调整position=0位置，limit=capicity
           System.out.println(byteBuffer.position());
           int readNumber = channelRead.read(byteBuffer);
           System.out.println(readNumber);
           if(-1==readNumber){
               break;
           }
           byteBuffer.flip();//此时limit=position，position=0;
           channelWrite.write(byteBuffer);
       }
       fileOutputStream.close();
       fileInputStream.close();
    }
}
