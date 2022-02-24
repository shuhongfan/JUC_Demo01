package com.shf3;

import lombok.Data;

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+person.name);

//        方式一： 通过对象获得
        Class<? extends Person> c1 = person.getClass();
        System.out.println(c1.hashCode());

//        方式二： forname获得
        Class<?> c2 = Class.forName("com.shf3.Student");
        System.out.println(c2.hashCode());

//        方式三： 通过 类名.class获得
        Class<Student> c3 = Student.class;
        System.out.println(c3.hashCode());

//        方式四 基本内置类型的包装类都有一个type属性
        Class<Integer> c4 = Integer.TYPE;
        System.out.println(c4);

//        获得父类类型
        Class<?> c5 = c1.getSuperclass();
        System.out.println(c5);

    }
}


@Data
class Person{
    public String name;
}

class Student extends Person{
    public Student(){
        this.name="学生";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}