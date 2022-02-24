package com.shf3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.*;

public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.shf3.Student2");

        for (Annotation annotation : c1.getAnnotations()) {
            System.out.println(annotation);
        }


        Tableshf tableshf = c1.getAnnotation(Tableshf.class);
        String value = tableshf.value();
        System.out.println(value);
    }
}

@Tableshf(value = "Tb_shf")
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student2{
    @Fieldshf(columnName = "db_id",type = "int",length = 10)
    private int id;
    private int age;
    private String name;
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tableshf{
    String value();
}

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldshf{
    String columnName();
    String type();
    int length();
}