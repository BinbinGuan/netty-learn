package com.netty.nettylearn;

public class BitTest {

    public static void main(String[] args) {
        // a=10000000, b=10000001
        int a=128,b=129;
        System.out.println(a&b);//两个操作数中位都为1，结果才为1，否则结果为0
        System.out.println(a|b);//两个位只要有一个为1，那么结果就是1，否则就为0
        System.out.println(~a);//如果位为0，结果是1，如果位为1，结果是0
        System.out.println(a^b);//两个操作数的位中，相同则结果为0，不同则结果为1
    }
}
