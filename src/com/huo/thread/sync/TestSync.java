package com.huo.thread.sync;

/**
 * 两个线程 模拟两个人 公用一个存折 同时在取钱
 * 需要对银行加锁
 *
 * @author huoyun
 * @date 2019/6/3-22:07
 */
public class TestSync {
    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread t1 = new Thread(runner);
        Thread t2 = new Thread(runner);

        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

class Bank {
    private int money = 3000;

    void get(String name, int want) {
        // 锁定当前对象 当前对象被锁定， 只有一个线程能进来
        synchronized (this) {
            System.out.println(name+"余额为:"+money);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (want > money) {
                System.out.println("没有这么多钱");
                return;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= want;
            System.out.println(name + ":" + money);
        }
    }

}

class Runner implements Runnable {
    private Bank bank = new Bank();

    @Override
    public void run() {
        bank.get(Thread.currentThread().getName(), 2000);
    }
}
