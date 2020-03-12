package com.cracker.jvm.classloader;

/** Java类加载机制的七个阶段，加载、验证、准备、解析、初始化、使用、卸载
 *  https://cloud.tencent.com/developer/article/1358290
 *
 * @author Cracker
 */
public class MyTest6 {
    public static void main(String[] args) {
        //①对Singleton类的主动使用
        Singleton singleton = Singleton.getSingleton();

        //13, 输出1
        System.out.println("counter1: " + Singleton.counter1);
        //14, 输出0
        System.out.println("counter2: " + Singleton.counter2);
    }
}

//②初始化之前有一个准备阶段，给类里面的静态成员变量赋默认值
class Singleton {
    //③默认值0 ⑧赋初值0
    public static int counter1;
    //④默认值null  ⑨执行私有构造方法
    private static Singleton singleton = new Singleton();
    //⑤没有执行
    private Singleton() {
        //10，被用户初始化之后的值 0+1=1
        counter1++;
        //11，被用户初始化之后的值 0+1=1
        counter2++; //准备阶段的重要意义

        System.out.println(counter1);
        System.out.println(counter2);
    }
    //⑥默认值0     12，完成对counter2的初始化
    public static int counter2 = 0;

    //⑦调用静态方法
    public static Singleton getSingleton() {
        return singleton;
    }
}