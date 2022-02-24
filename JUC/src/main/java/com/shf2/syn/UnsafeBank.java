package com.shf2.syn;


public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");

        Drawing you = new Drawing(account, 50, "你");
        Drawing girlfriend = new Drawing(account, 100, "女朋友");

        you.start();
        girlfriend.start();
    }
}

//账户
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    @Override
    public void run() {
//        synchronized  默认锁的是this
//        锁的对象就是变化的量，需要增删改查的对象
        synchronized (account){
//        判断有没有钱
            if (account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+" 钱不够，取不了");
                return;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//        卡内余额 = 余额 - 你取的钱
            account.money = account.money - drawingMoney;
//        你手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name+" 余额为："+account.money);
            System.out.println(this.getName()+" 手里的钱："+nowMoney);
        }
    }
}