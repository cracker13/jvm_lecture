package com.cracker.jvm.classloader;

/**
 * @author Cracker
 */
public class MyTest18 {
    public static void main(String[] args) throws Exception{
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
