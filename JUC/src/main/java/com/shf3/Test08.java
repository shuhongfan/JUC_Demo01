package com.shf3;

import java.util.Properties;

public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException {
//        获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

//        获取系统类加载器的父类加载器---》拓展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

//        获取扩展类加载器的父类加载----》根加载器c++
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);


//        测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.shf3.Son").getClassLoader();
        System.out.println(classLoader);

//        测试JDK内置的类是谁加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

//        Properties properties = System.getProperties(System.getProperty("java.class.path"));
//        System.out.println(properties);
    }
}
