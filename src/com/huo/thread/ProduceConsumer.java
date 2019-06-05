package com.huo.thread;

/**
 * 生产者消费者
 *
 * @author huoyun
 * @date 2019/6/5-17:01
 */
public class ProduceConsumer {

    public static void main(String[] args) {
        Basket basket = new Basket();
        new Thread(new Produce(basket), "p1").start();
        new Thread(new Produce(basket), "p2").start();

        new Thread(new Consumer(basket), "c1").start();

    }
}


/**
 * 用stack来模拟  下面的封底的
 * 代表装馒头的框
 */
class Basket {
    /**
     * 这个篮子 能装10个窝头
     */
    private WoTou[] woTous = new WoTou[3];
    private int index = 0;

    /**
     * 拿出一个馒头
     */
    synchronized WoTou pop() {
        while (index == 0) {
            System.out.println("=======================");
            // 通知生产者起床
            System.out.println("没吃的了 我要通知生产者了");
            try {
                this.wait();
//                this.notify();  线程已经休息了  这句话写在这不行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 唤醒生产者 但是 现在 生产者 还不能拿到锁 知道当前 线程释放 锁  也就是 这个方法 走完
        this.notifyAll();
        // 确保是要拿 --index 因为 index 是生产者下次要生产的index
        return this.woTous[--index];
    }

    /**
     * 做出一个馒头
     * 应该是只要篮子不空着 就可以通着消费者来消费了
     */
    synchronized void push(WoTou woTou) {
        while (index == woTous.length) {
            System.out.println("馒头装满了 我开始等着");
            System.out.println("=======================");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();

        woTous[index] = woTou;
        index++;
        System.out.println("make >> " + woTou);
    }
}

/**
 * 生产者
 */
class Produce implements Runnable {
    private Basket basket;

    Produce(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            basket.push(new WoTou(Thread.currentThread().getName()+":"+i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("<<<<<<<<<<<<<<打烊了 我干不动了>>>>>>>>>>>>>>>");
    }
}

/**
 * 消费者 吃货
 */
class Consumer implements Runnable {
    private Basket basket;

    Consumer(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            WoTou pop = basket.pop();
            System.out.println("eat >> " + pop);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 窝头类
 */
class WoTou {
    String id;

    WoTou(String i) {
        this.id = i;
    }

    @Override
    public String toString() {
        return "窝头ID:" + id;
    }
}