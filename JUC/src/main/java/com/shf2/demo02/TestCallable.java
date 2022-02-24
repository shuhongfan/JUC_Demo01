package com.shf2.demo02;

import com.shf2.demo01.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    private String url; // 网络图片地址
    private String name; // 保存文件名

    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("http://n.sinaimg.cn/news/1_img/upload/cf3881ab/400/w1000h1000/20200702/2c1c-ivwfwmn5979414.jpg", "1.jpg");
        TestCallable t2 = new TestCallable("http://n.sinaimg.cn/news/1_img/upload/cf3881ab/99/w1000h699/20200702/51b8-ivwfwmn5979346.jpg", "2.jpg");
        TestCallable t3 = new TestCallable("http://n.sinaimg.cn/news/1_img/upload/cf3881ab/123/w1000h723/20200702/110c-ivwfwmn5993065.jpg", "3.jpg");

//        创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> r1 = service.submit(t1);
        Future<Boolean> r2 = service.submit(t2);
        Future<Boolean> r3 = service.submit(t3);

//        获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

//        关闭服务
        service.shutdown();
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
