package com.shf2.demo01;

import com.shf.bq.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread{

    private String url; // 网络图片地址
    private String name; // 保存文件名

    public TestThread2(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("http://n.sinaimg.cn/news/1_img/upload/cf3881ab/400/w1000h1000/20200702/2c1c-ivwfwmn5979414.jpg", "1.jpg");
        TestThread2 t2 = new TestThread2("http://n.sinaimg.cn/news/1_img/upload/cf3881ab/99/w1000h699/20200702/51b8-ivwfwmn5979346.jpg", "2.jpg");
        TestThread2 t3 = new TestThread2("http://n.sinaimg.cn/news/1_img/upload/cf3881ab/123/w1000h723/20200702/110c-ivwfwmn5993065.jpg", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}


class WebDownloader{
//    下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
