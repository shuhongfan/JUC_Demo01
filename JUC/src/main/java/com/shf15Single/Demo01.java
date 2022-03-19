package com.shf15Single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Demo01 {
    public static void main(String[] args) throws Exception {
//        LazyMan instance1 = LazyMan.getInstance();

        Field shuhongfan = LazyMan.class.getDeclaredField("shuhongfan");
        shuhongfan.setAccessible(true);

        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
//        无视私有构造器
        declaredConstructor.setAccessible(true);

        LazyMan instance1 = declaredConstructor.newInstance();
        shuhongfan.set(instance1,false);

        LazyMan instance2 = declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }
}
