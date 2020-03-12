package com.cracker.jvm.classloader;

/*
扩展类加载器的使用
扩展类加载器从指定的目录下的jar包中加载class文件
jar cvf test.jar com/cracker/jvm/classloader/MyTest1.class
java -Djava.ext.dirs=./ com.cracker.jvm.classloader.MyTest22
 */
public class MyTest22 {

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());

        System.out.println(MyTest1.class.getClassLoader());
    }

    static {
        System.out.println("MyTest22 initialize");
    }
}
