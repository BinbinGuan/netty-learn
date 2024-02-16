package com.netty.nettylearn.netty;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestScatteringReads {
    public static void main(String[] args) {
        // twr
        try (FileChannel channel = new RandomAccessFile("data.txt", "r").getChannel()) {
            ByteBuffer bufferOne = ByteBuffer.allocate(3);
            ByteBuffer buffertwo=  ByteBuffer.allocate(3);
            ByteBuffer bufferthree= ByteBuffer.allocate(5);
            channel.read(new ByteBuffer[]{bufferOne,buffertwo,bufferthree});
            bufferOne.flip();
            buffertwo.flip();
            bufferthree.flip();

        } catch (IOException e) {
        }
    }
}
