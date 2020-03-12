package com.cracker.jvm.g1;

/**
 * -verbose:gc 输出gc详细信息
 * -Xms20M 堆空间初始大小
 * -Xmx20M 堆空间最大小
 * -Xmn10M 堆空间新生代大小
 * -XX:+UseG1GC
 * -XX:+printGCDetails 打印gc详细信息
 * -XX:+printGCDateStamps 打印时间戳
 * -XX:MaxGCPauseMillis=200ms 最大停顿时间
 * -XX:SurvivorRatio=8 eden和survivor比例
 *
 * jdk1.8默认收集器
 * PSYoungGen: Parallel Scavenge （新生代垃圾收集器）
 *
 * ParOldGen: Parallel old （老年代垃圾收集器）
 *
 * @author
 */

public class MyTest1 {


    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] bytes1 = new byte[2 * size];
        byte[] bytes2 = new byte[2 * size];
        byte[] bytes3 = new byte[3 * size];
        byte[] bytes4 = new byte[3 * size];


        System.out.println("hello word");

    }
}
