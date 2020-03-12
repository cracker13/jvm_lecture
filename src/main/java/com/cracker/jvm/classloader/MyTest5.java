package com.cracker.jvm.classloader;

import java.util.Random;

/**
 * 当一个接口(类)在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
 *
 * 加载和初始化有不同：
 *  左边生成的class文件叫做加载
 *  执行内部的代码比如静态块叫初始化
 *
 * @author Cracker
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
//        System.out.println(MyParent5_1.thread);
//        new C();
//        new C();
    }
}

class MyGrandpa{
    public static Thread thread = new Thread(){
        {
            System.out.println("Grandpa invoked");
        }
    };
}

interface MyParent5{

//    public static int a = 5;

    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5 invoked");
        }
    };
}

class MyChild5 implements MyParent5 {
    //到底加不加在取决于编译期还是运行期确定值
    //注意final关键字在class和interface里的不同
    public static int b = 7;
}

interface MyGrandpa1{
    public static Thread thread = new Thread(){
        {
            System.out.println("Grandpa invoked");
        }
    };
}

interface MyParent5_1 extends MyGrandpa1{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5_1 invoked");
        }
    };
}


//class C{
//    {
//        System.out.println("hello");
//    }
//
//    public C(){
//        System.out.println("C");
//    }
//}