package com.cracker.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @author Cracker
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> clazz = loader1.loadClass("com.cracker.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader1.loadClass("com.cracker.jvm.classloader.MyPerson");

        System.out.println(clazz == clazz2);

        Object object1 = clazz.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
