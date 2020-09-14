package com.tjpu.Socket.NioDemo.Demo;

import java.nio.ByteBuffer;

public class ByteBufferDemo3 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        for(int i=0;i<byteBuffer.capacity();i++){
            byteBuffer.put((byte)i);
        }
        ByteBuffer byteBuffer1 = byteBuffer.asReadOnlyBuffer();//创建一个buffer只读的
        System.out.println(byteBuffer.getClass());
        System.out.println(byteBuffer1.getClass());
        byteBuffer1.flip();
        System.out.println("byteBuffer的position："+byteBuffer.position());
        System.out.println("byteBuffer1的position:"+byteBuffer1.position());
        for(int i=0;i<byteBuffer1.capacity();i++){
            System.out.println(byteBuffer1.get());
        }
    }
}
