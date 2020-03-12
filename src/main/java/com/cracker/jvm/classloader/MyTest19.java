package com.cracker.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @author
 */

public class MyTest19 {
    public static void main(String[] args) throws Exception{
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();


        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class);




    }

}
