package com.tjpu.Socket.NioDemo.Demo;

import java.nio.ByteBuffer;

public class ByteBufferDemo2 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        for(int i=0;i<byteBuffer.capacity();++i){
            System.out.println("当前放入Buffer的i是:"+i);
            byteBuffer.put((byte)i);
        }
        byteBuffer.position(2);
        byteBuffer.limit(8);
        ByteBuffer resetBuffer = byteBuffer.slice();//创建新的Buffer可以写。然后修改，对应原来的buffer区域也会修改（数据是共享）

        System.out.println("byteBuffer.slice()之后---position位置："+resetBuffer.position());
        System.out.println("byteBuffer.slice()之后---limit："+resetBuffer.limit());
        System.out.println("byteBuffer.slice()之后---capacity："+resetBuffer.capacity());

        for(int i=0;i<resetBuffer.capacity();i++){
            byte anInt = resetBuffer.get();
            resetBuffer.put(i, (byte) (anInt*2));
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        while (byteBuffer.hasRemaining()){
            System.out.println("修改resetBuffer之后对应的byteBuffer结果："+byteBuffer.get());
        }

    }
}
