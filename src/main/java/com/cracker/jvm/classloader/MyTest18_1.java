package com.cracker.jvm.classloader;

/**
 * 在根类加载器路径加入MyTest1，结果返回null，说明是这个类是根类加载器加载的
 * @author
 */

public class MyTest18_1 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/chen/Downloads/");
        Class<?> clazz = loader1.loadClass("com.cracker.jvm.classloader.MyTest1");

        System.out.println("clazz: " + clazz.hashCode());
        System.out.println("clazz loader : " + clazz.getClassLoader() );
    }

}
