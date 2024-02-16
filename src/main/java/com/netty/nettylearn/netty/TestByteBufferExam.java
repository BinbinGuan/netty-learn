package com.netty.nettylearn.netty;

import java.nio.ByteBuffer;

public class TestByteBufferExam {

    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello world\n I'm zhangsan\n How ary you".getBytes());
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n') {
                int lenth = i + 1 - source.position();
                ByteBuffer target = ByteBuffer.allocate(lenth);
                for (int j = 0; j < lenth; j++) {
                    target.put(source.get());
                }

            }

        }

    }
}
