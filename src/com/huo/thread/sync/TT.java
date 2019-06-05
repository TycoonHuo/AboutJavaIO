package com.huo.thread.sync;

/**
 * 10年前面试题
 * 锁住了方法 另一个方法能被执行吗
 * 看具体代码
 *
 * 对于同一个资源，  如果有的方法加锁了 有的方法没有加锁 那么资源会被篡改
 * 一般来说 读方法 不加锁 修改加锁
 *
 * @author huoyun
 * @date 2019/6/5-15:50
 */
public class TT {
    int b = 100;

    void m1() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(5000);
            b = 1000;
            System.out.println(Thread.currentThread().getName() + ">>m1<<" + b);
        }
    }

    // 这个方法也加锁了 那么上面的方法执行中， 这个方法无法执行，因为没有当前对象的锁
    synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + ">>m2<<" + b);
    }

    // 这个对象没有加锁  所以其他线程可以执行
    void m3() {
        System.out.println(Thread.currentThread().getName() + ">>m3<<" + b);
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new MyThread(1), "t1").start();
        Thread.sleep(300);
        new Thread(new MyThread(2), "t2").start();
    }
}

class MyThread implements Runnable {
    static TT tt = new TT();
    int flag;

    MyThread(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag == 1) {
            try {
                tt.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            tt.m2();
        }
    }
}
