package com.cracker.jvm.classloader;

import java.io.*;

/**
 * 自定义类加载器
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private String path;// 指定从哪里加载类

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super();//将系统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);//显示指定父加载器
        this.classLoaderName = classLoaderName;
    }

    /*
        MyTest23时新增，用于指定新的系统类加载器时，所用到
     */
    public MyTest16(ClassLoader classLoader) {
        super(classLoader);
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("--findClass name:" + className);
        System.out.println("--classloader name:" + this.classLoaderName);

        byte[] data = loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        className = className.replace(".", "/");

        try {
            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args)throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/chen/Downloads/");
        Class<?> clazz = loader1.loadClass("com.cracker.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println();

        loader1 = null;
        clazz = null;
        object = null;

        System.gc();

        loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/chen/Downloads/");
        clazz = loader1.loadClass("com.cracker.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);

        /*MyTest16 loader2 = new MyTest16(loader1,"loader2");
        loader2.setPath("/Users/chen/Downloads/");
        Class<?> clazz2 = loader2.loadClass("com.cracker.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);

        System.out.println();

        MyTest16 loader3 = new MyTest16(loader2, "loader3");
        loader3.setPath("/Users/chen/Downloads/");
        Class<?> clazz3 = loader3.loadClass("com.cracker.jvm.classloader.MyTest1");
        System.out.println("class:" + clazz3.hashCode());
        Object object3 = clazz3.newInstance();
        System.out.println(object3);*/
    }

}
