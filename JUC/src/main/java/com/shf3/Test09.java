package com.shf3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.shf3.User");

//        获得类的名字
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

//        获得类的属性
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

//        获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);


//        获得类的方法
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("正常的："+method);
        }

        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }
}
