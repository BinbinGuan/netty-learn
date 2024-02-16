package com.netty.nettylearn.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class FileChannelTest {

    public static void main(String[] args) {

        try (FileChannel fileChannel = new FileInputStream("data.txt").getChannel()) {

            //准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while (true) {

                int len = fileChannel.read(buffer);
                log.debug("读取到的字节数{}", len);
                if (len == -1) {
                    break;
                }

                buffer.flip();//切换读模式

                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    log.debug("实际字节 {}", (char) b);

                }

                buffer.clear();//切换至写模式
            }


        } catch (Exception e) {

        }

    }
}
