package com.netty.nettylearn;

public class ThreadTst  extends  Thread{



    private String name;


    public ThreadTst(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        new ThreadTst("test").run();
        new ThreadTst("test").start();
    }
}
