package com.cracker.jvm.classloader;


//调用ClassLoader类的loadClass方法加载一个类,并不是对类的主动使用,不会导致类的初始化
public class MyTest12 {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // 这行代码不会导致类的初始化
        Class<?> clazz = classLoader.loadClass("com.cracker.jvm.classloader.CL");
        System.out.println(clazz);

        System.out.println("----------");

        clazz = Class.forName("com.cracker.jvm.classloader.CL");

        System.out.println("----------");

        System.out.println(clazz);

    }
}

class CL {
    static {
        System.out.println("Class CL");
    }
}
