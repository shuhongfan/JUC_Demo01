package com.shf.single;

import java.lang.reflect.Constructor;

//enum是一个什么？ 本身也是一个class类
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) throws NoSuchMethodException {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        EnumSingle instance2 = EnumSingle.INSTANCE;

        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);

        System.out.println(instance1);
        System.out.println(instance2);
    }
}
