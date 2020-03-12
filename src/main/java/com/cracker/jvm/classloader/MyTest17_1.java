package com.cracker.jvm.classloader;

/**
 * 加载器会先去左边的class文件里面找，所以要先把MyCat.class、MySample.class删除
 * @author Cracker
 */
public class MyTest17_1 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/chen/Downloads/");

        Class<?> clazz = loader1.loadClass("com.cracker.jvm.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());

        Object object = clazz.newInstance();
    }

}
