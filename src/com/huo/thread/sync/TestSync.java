package com.huo.thread.sync;

/**
 * 线程的同步
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
        t2.start();
        t1.start();
    }
}

class Timer {
    //    static int num;
    int num;

    synchronized void add(String name) {
        num++;
        System.out.println(name + "你是第" + num + "个访问这个方法的人");
    }
}

class Runner implements Runnable {
    private Timer timer = new Timer();

    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}
