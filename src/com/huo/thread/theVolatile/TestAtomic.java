package com.huo.thread.theVolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * i++  分为三步 先 读 -> 改 -> 返回
 *
 * juc包里的 原子性操作
 * @author huoguangyao
 * @date 2019/6/6 13:16
 */
public class TestAtomic implements Runnable {

    AtomicInteger i = new AtomicInteger(0);

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
//            synchronized (this) {
//                i++;
//            }
            // i++
            i.getAndIncrement();
        }
        System.out.println(Thread.currentThread().getName() + ">" + i);
    }

    public static void main(String[] args) {
        TestAtomic testAtomic = new TestAtomic();
        for (int i = 0; i < 1000; i++) {
            new Thread(testAtomic, "t" + i).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ">" + testAtomic.i);
    }
}
