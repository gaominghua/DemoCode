package com.tjpu.Socket.NioDemo.Demo;

import java.nio.ByteBuffer;

import static java.lang.Byte.*;

/**
 * ByteBUffer可以放入其他类型的数据，但是存取数据必须一致
 */
public class ByteBufferDemo {
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(100);
       // ByteBuffer buffer=ByteBuffer.allocateDirect(100);//创建堆外内存
        buffer.putChar('a');
        buffer.putInt(2);
        buffer.putLong(50000L);
        buffer.putShort((short) 2);
        buffer.putDouble(12.4);
        System.out.println("Position的位置："+buffer.position());
        buffer.flip();
        System.out.println(buffer.getChar());
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getDouble());
    }
}
