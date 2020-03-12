package com.cracker.jvm.classloader;

/*
对于父类有主动使用，对子类没有，所以就不打印静态方法
 */
public class MyTest11 {

    public static void main(String[] args) {
        System.out.println(Child3.a);
        System.out.println("--------");
        Child3.doSomething();
    }

}

class Parent3 {
    static int a = 3;
    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("Child2 static block");
    }
}