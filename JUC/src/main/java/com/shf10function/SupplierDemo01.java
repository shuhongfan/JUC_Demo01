package com.shf10function;

import java.util.function.Supplier;

/**
 * supplier 供给型接口：没有参数，只有返回值
 */
public class SupplierDemo01 {
    public static void main(String[] args) {
//        Supplier<Integer> supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                System.out.println("get()");
//                return 1024;
//            }
//        };

        Supplier<Integer> supplier = ()-> 1024;

        System.out.println(supplier.get());
    }
}


/**
 * @FunctionalInterface
 * public interface Supplier<T> {
 *      T get();
 */