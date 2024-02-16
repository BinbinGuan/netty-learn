package com.netty.nettylearn.netty;

import java.nio.ByteBuffer;

public class ButeBufferTest {

    public static void main(String[] args) {
        System.out.printf("", ByteBuffer.allocate(10).getClass());
        System.out.printf("", ByteBuffer.allocateDirect(10).getClass());
    }
}
