package com.shf3;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
class User{
    private String name;
    private int id;
    private int age;
}

//什么叫反射
public class Test03  extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
//        一个类在内存中只有一个class对象
//        一个类被加载后，类的整个结构都会被封装在Class对象中
        Class c1 = Class.forName("com.shf3.User");
        System.out.println(c1);

    }
}


