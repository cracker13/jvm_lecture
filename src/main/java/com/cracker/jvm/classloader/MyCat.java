package com.cracker.jvm.classloader;

/**
 * 命名空间的重要说明
 *
 * 1.子加载器所加载的类可以访问父加载器所加载的类
 * 2.父加载器所加载的类无法访问子加载器所加载的类
 * @author Cracker
 */
public class MyCat {
    public MyCat(){
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());
//        System.out.println("from MyCat: " + MySample.class);
    }
}
