package com.shf2.demo02;

public class TestLambda2 {
    public static void main(String[] args) {
        ILove love = new ILove() {
            @Override
            public void love(int a) {
                System.out.println(a);
            }
        };
        love.love(6);
    }
}

interface ILove{
    void love(int a);
}

class Love implements ILove{

    @Override
    public void love(int a) {
        System.out.println("I love you-->"+a);
    }
}
