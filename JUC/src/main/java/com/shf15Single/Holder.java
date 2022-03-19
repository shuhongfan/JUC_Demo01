package com.shf15Single;

//静态内部类
public class Holder {
//    只要是单例模式，构造器私有
    private Holder(){

    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER=new Holder();
    }
}
