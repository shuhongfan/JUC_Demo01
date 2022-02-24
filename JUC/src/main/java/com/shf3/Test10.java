package com.shf3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test10 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        获得Class对象
        Class<?> c1 = Class.forName("com.shf3.User");

//        构造一个对象
        User user = (User) c1.newInstance(); // 本质是调用了类的无参构造器
        System.out.println(user);


//        通过构造器创建对象
        Constructor<?> constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) constructor.newInstance("shf", 001, 23);
        System.out.println(user2);

//        通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "sgfd");
        System.out.println(user3.getName());

//        通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");


        name.setAccessible(true);
        name.set(user4,"dsd");
        System.out.println(user4.getName());
    }
}
