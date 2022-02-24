package com.shf.function;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.function.Supplier;

/**
 * 供给型接口 没有参数，只有返回值
 */
public class Demo04 {
    public static void main(String[] args) {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "1024";
//            }
//        };

        Supplier<String> supplier = () ->"1024";
        System.out.println(supplier.get());
    }
}
