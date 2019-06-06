package com.huo.thread;

public class SecondThread implements Runnable {
    int i;

    @Override
    public void run() {
        synchronized (this) {
            for (; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
//            System.out.println(Thread.currentThread().getName() + "-" + i);
            if (i == 10) {
                SecondThread st = new SecondThread();
                new Thread(st, "线程2").start();
                new Thread(st, "线程1").start();
            }
        }
    }

}