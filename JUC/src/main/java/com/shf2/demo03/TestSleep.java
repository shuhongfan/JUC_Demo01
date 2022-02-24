package com.shf2.demo03;

import java.util.Date;

//模拟网络延时
public class TestSleep{
    public static void tenDown() throws InterruptedException {

        int num = 10;

        while (true){
            Thread.sleep(1000);

            System.out.println(num--);

            if (num<=0) break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        tenDown();
    }
}
