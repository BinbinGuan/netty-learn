package aio;

import java.nio.ByteBuffer;

public class ByteBufferDemo {



    public static void main(String[] args) {
        System.out.println("------初始化Buffer------");
        ByteBuffer bb = ByteBuffer.allocate(100);
        System.out.println("当前位置在" + bb.position());
        System.out.println("限制位置在" + bb.limit());
        System.out.println("容量是" + bb.capacity());
        System.out.println("------put之后------");
        String str = "Hello";
        byte[] bytes = str.getBytes();
        bb.put(bytes);
        System.out.println("当前位置在" + bb.position());
        System.out.println("限制位置在" + bb.limit());
        System.out.println("容量是" + bb.capacity());
        System.out.println("------调用flip之后------");
        bb.flip();
        System.out.println("当前位置在" + bb.position());
        System.out.println("限制位置在" + bb.limit());
        System.out.println("容量是" + bb.capacity());

        String str1 = "Hello";
        byte[] bytes1 = str1.getBytes();
        bb.put(bytes1);
        System.out.println("当前位置在" + bb.position());
        System.out.println("限制位置在" + bb.limit());
        System.out.println("容量是" + bb.capacity());
        bb.flip();

        System.out.println("当前位置在" + bb.position());
        System.out.println("限制位置在" + bb.limit());
        System.out.println("容量是" + bb.capacity());
        char ch;
        while (bb.hasRemaining()) {
            ch = (char) bb.get();
            System.out.print(ch);
        }
    }


}
