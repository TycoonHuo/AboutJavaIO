package com.huo.thread.sync;

import static java.lang.Thread.sleep;

/**
 * 两个线程 分别持有两个东西， 然后还想要对象手里的
 *
 * 死锁问题
 *
 * @author huoyun
 * @date 2019/6/5-15:38
 */
public class TestDeadLock implements Runnable {
    /**
     * 这里static 为了锁住的是同一个东西
     */
    private int flag;
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    TestDeadLock(int flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        new Thread(new TestDeadLock(1)).start();
        new Thread(new TestDeadLock(2)).start();
    }

    @Override
    public void run() {
        if (flag == 1) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + ":锁住了o1");

                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + ":锁住了o2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + ":锁住了o2");

                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + ":锁住了o1");
                }
            }
        }
    }
}
