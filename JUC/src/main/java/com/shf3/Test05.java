package com.shf3;

import java.lang.annotation.ElementType;

//所有类型的class
public class Test05 {
    public static void main(String[] args) {
        Class<Object> c1 = Object.class;//类
        Class<Comparable> c2 = Comparable.class;//接口
        Class<String[]> c3 = String[].class;//一维数组
        Class<int[][]> c4 = int[][].class;//二维数组
        Class<Override> c5 = Override.class;//注解
        Class<ElementType> c6 = ElementType.class;//枚举
        Class<Integer> c7 = Integer.class;//基本数据类型
        Class<Void> c8 = void.class;//void
        Class<Class> c9 = Class.class;//class

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c9);


        int[] a=new int[10];
        int[] b=new int[100];
//        只要元素类型和维度一样，就是同一个Class
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}
