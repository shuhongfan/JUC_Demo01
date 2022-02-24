package com.shf.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * 现在有5个用户！ 筛选
 * 1. ID必须是偶数
 * 2.年龄必须大于23岁
 * 3.用户名转为大写字母
 * 4.用户名字母倒着排序
 * 5.只输出一个用户
 */
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(6, "f", 26);

//        集合就是存储
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

//        计算交给Stream流   链式编程
        list.stream()
                .filter(u->u.getId()%2==0)
                .filter(u->u.getAge()>23)
                .map(u->u.getName().toUpperCase(Locale.ROOT))
                .sorted((uu1,uu2)->uu1.compareTo(uu2))
                .limit(1)
                .forEach(System.out::println);

    }
}
