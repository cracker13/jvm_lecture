package com.cracker.jvm.classloader;

/**
 * MyChild1.str 对MyParent1的主动使用，类被初始化，静态代码块执行。
 * MyChild1.str2 对MyChild1的主动使用，类被初始化，父类先被初始化，静态代码块执行。
 *
 *
 * -XX:+TraceClassLoading,用于追踪类的加载信息并打印出来
 *
 * -XX:+<option> 表示开启option选项
 * -XX:-<option> 表示关闭option选项
 * -XX:<option>=<value> 表示将option选项的值设置为value
 *
 * @author Cracker
 */
public class MyTest1 {

    public static void main(String[] args) {
        System.out.println(MyChild1.str);
    }
}

class MyParent1 {
    //静态字段
    public static String str = "hello world";

    //静态代码块 在类初始化时 执行
    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    //静态字段
    public static String str2 = "welcome";

    //静态代码块
    static {
        System.out.println("MyChild1 static block");
    }
}
