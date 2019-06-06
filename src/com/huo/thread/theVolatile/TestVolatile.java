package com.huo.thread.theVolatile;

/**
 * volatile 关键字
 * 线程之间 工作内存 彼此隔离
 *
 * main 和 t1线程分别 都有flag的缓存  t1 修改完 又推送给了主存  但是主存不会主动推送给main 所以 main线程中的 tv.flag 一直还是false
 * 导致 程序无法终止
 * @author huoguangyao
 * @date 2019/6/6 13:07
 */
public class TestVolatile implements Runnable {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println(Thread.currentThread().getName()+":"+flag);
    }

    public static void main(String[] args) {
        TestVolatile tv = new TestVolatile();
        new Thread(tv,"t1").start();

        while (true) {
            if (tv.flag) {
                System.out.println("######" + tv.flag);
                break;
            }
        }

    }
}
