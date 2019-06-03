package com.huo.thread.stop;

/**
 * 优雅的停止一个线程
 *
 * @author huoyun
 * @date 2019/6/3-21:51
 */
public class Stop {
    public static void main(String[] args) {
        T t = new T();
        Thread t1 = new Thread(t);

        t1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>" + i);
            if (i == 5) {
                t.shutdown();
            }
        }
    }
}

class T implements Runnable {
    private boolean flag = true;

    /**
     * 这个方法用来被别的线程调用
     */
    public void shutdown() {
        flag = false;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ">>" + i + ":" + flag);
            if (!flag) {
                break;
            }
        }
    }
}
