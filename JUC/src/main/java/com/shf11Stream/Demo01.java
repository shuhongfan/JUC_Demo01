package com.shf11Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Demo01 {
    User u1 = new User(1, "a", 21);
    User u2 = new User(2, "b", 22);
    User u3 = new User(3, "c", 23);
    User u4 = new User(4, "d", 24);
    User u5 = new User(5, "e", 25);
    User u6 = new User(6, "f", 26);
//    集合就是存储
    List<User> list = Arrays.asList(u1, u2, u3, u4, u5,u6);

    @Test
    public void  test1(){
//        lambda表达式、链式编程、函数式接口、Stream流式计算
        list.stream()
                .filter(u->u.getId()%2==0)  // 获取ID必须是偶数
                .filter(u->u.getAge()>23) // 年龄必须大于23岁
                .map(u->u.getName().toUpperCase(Locale.ROOT)) // 用户名转换为大写字母
                .sorted((uu1,uu2)->uu2.compareTo(uu1)) // 用户名字母倒序
                .limit(1) // 只输出一个用户
                .forEach(System.out::println);
    }
}
