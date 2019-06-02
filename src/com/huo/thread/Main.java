package com.huo.thread;

/**
 * 开始玩线程
 * 能使用接口就用接口
 *
 * @author huoyun
 * @date 2019/6/1-22:49
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"   "+i);
            if (i == 10) {
                System.exit(0);
            }
        }
    }
}
