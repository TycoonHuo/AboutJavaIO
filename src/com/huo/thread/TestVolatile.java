package com.huo.thread;

public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while (true) {
            if (!td.isFlag()) {
                System.out.println("########:" + td.isFlag());
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        try {
            // 该线程 sleep(200), 导致了程序无法执行成功
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = !flag;

        System.out.println("flag=" + isFlag());
    }

    boolean isFlag() {
        return flag;
    }
}