package com.huo.thread.sleep;

import java.util.Date;

/**
 * 练习sleep方法
 * @author huoyun
 * @date 2019/6/2-23:10
 */
public class TestSleep {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.currentThread().getName()+":"+new Date());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        });
        t.start();
        try {
            Thread.sleep(5000);
            // 打断t线程  t线程会进入catch
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
