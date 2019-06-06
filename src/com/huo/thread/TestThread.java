package com.huo.thread;

import org.junit.jupiter.api.Test;

/**
 * 测试类
 *
 * @author huoguangyao
 * @date 2019/6/3 17:04
 */

class TestThread {

    @Test
    void test1() {
        Pro pro = new Pro();
        for (int i = 0; i < 10; i++) {
            new Thread(pro).start();
        }
    }
}

class Pro implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
        }
    }
}
