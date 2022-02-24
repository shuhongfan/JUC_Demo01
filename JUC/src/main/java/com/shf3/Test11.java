package com.shf3;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test11 {
    public void test01(Map<String,User> map, List<User> list){
        System.out.println("test01");
    }

    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test11.class.getMethod("test01", Map.class, List.class);
        for (Type genericParameterType : method.getGenericParameterTypes()) {
            System.out.println("#"+genericParameterType);
            if (genericParameterType instanceof ParameterizedType){
                for (Type actualTypeArgument : ((ParameterizedType) genericParameterType).getActualTypeArguments()) {
                    System.out.println(actualTypeArgument);
                }

            }
        }

        method = Test11.class.getMethod("test02");
        for (Type genericParameterType : method.getGenericParameterTypes()) {
            System.out.println("#"+genericParameterType);
            if (genericParameterType instanceof ParameterizedType){
                for (Type actualTypeArgument : ((ParameterizedType) genericParameterType).getActualTypeArguments()) {
                    System.out.println(actualTypeArgument);
                }

            }
        }
    }
}
