package com.huo.thread.sleep;

import java.util.Arrays;
import java.util.Date;

/**
 * 用一个flag来控制线程的停止
 * @author huoyun
 * @date 2019/6/2-23:15
 */
public class TestSleep02 {
    public static void main(String[] args) {
        T t = new T();
        Thread t1 = new Thread(t);
        t1.start();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.flag = false;
    }
}

class T implements Runnable {
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + ":" + new Date());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
