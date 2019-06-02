package com.huo.thread.join;

/**
 * 谁join 就等着让他执行完再说
 *
 * @author huoyun
 * @date 2019/6/2-23:34
 */
public class TestJoin {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();

        try {
//            Thread.sleep(500);
            t1.join();
            t2.start();

            t2.join();
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
