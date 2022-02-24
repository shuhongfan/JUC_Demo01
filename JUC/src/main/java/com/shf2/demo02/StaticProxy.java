package com.shf2.demo02;

/**
 * 真实对象和代理对象都要实现同一个接口
 */
public class StaticProxy {
    public static void main(String[] args) {

        new Thread(()-> System.out.println("我爱你")).start();

        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

// 真实角色，你去结婚
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("快乐");
    }
}

// 代理角色，帮助你结婚
class WeddingCompany implements Marry{

    // 代理谁  真实目标角色
    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry(); // 这是真实对象
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}
