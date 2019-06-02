package com.huo.thread.yield;

/**
 * yield 高风亮节
 *
 * @author huoyun
 * @date 2019/6/2-23:51
 */
public class TestYield {
    public static void main(String[] args) {
        System.out.println(0%50);
//
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
//                if (i % 10 == 0) {
//                    Thread.yield();
//                }
//            }
//        });
//        t1.setName("t1");
//
//        Thread t2 = new Thread(() -> {
//            boolean flag = true;
//            while (flag) {
//                for (int i = 0; i < 100; i++) {
//                    System.out.println(Thread.currentThread().getName() + ":" + i+ ":" + flag);
//                    if (i % 50 == 0) {
//                        flag = false;
//                    }
//                }
//            }
//        });
//        t2.setName("t2");
//
//        t1.start();
//        t2.start();
    }
}
