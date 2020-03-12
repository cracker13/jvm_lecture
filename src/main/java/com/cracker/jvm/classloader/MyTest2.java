package com.cracker.jvm.classloader;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在类的常量池中
 * 本质上，调用类并没有直接引用到定义常量的类，因此不会触发定义常量的类初始化
 * 注意：这里指的是将常量存放到MyTest2的常量池中，之后MyTest2与Parent就没有任何关系
 * 甚至，我们可以将MyParent2的class文件删除
 *
 * 助记符：
 * ldc:表示将int、float、String的类型的常量值从常量池中推送至栈顶（所谓栈顶就是接下来要去用的）
 * bipush:表示将单字节-128~127的常量值推送至栈顶
 * sipush:表示将短整型-32768~32767的常量值推送至栈顶
 * iconst_1表示将int类型1推送至栈顶（iconst_m1~inconst_5）
 *
 * @author Cracker
 */
public class MyTest2 {

    public static void main(String[] args) {
        System.out.println(MyParent2.str);
    }
}

class MyParent2 {

    public static final String str = "hello world";

    public static final short s = 7;

    public static final int i = 128;

    public static final int m = 2;

    static {
        System.out.println("MyParent2 static block");
    }
}
