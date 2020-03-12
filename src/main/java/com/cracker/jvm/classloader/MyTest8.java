package com.cracker.jvm.classloader;

import java.util.Random;

/**
 * 有无final、Random().nextInt()的区别
 */
public class MyTest8 {

    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}


class FinalTest {

    public static final int x = new Random().nextInt(3);
    public static int y = 3; // 编译器常量

    //静态代码块没有被执行，说明这个类没有被初始化
    static {
        System.out.println("FinalTest invoked!");
    }
}