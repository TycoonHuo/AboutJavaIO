package com.huo.io;

import java.io.*;

/**
 * 对象流，把对象写在硬盘上 也叫持久化
 *
 * @author huoyun
 * @date 2019/6/1-21:59
 */
public class TestObjectStream {
    public static void main(String[] args) {
        ObjectOutput oo = null;
        ObjectInput oi = null;
        try {
            oo = new ObjectOutputStream(new FileOutputStream("test.txt"));
            oo.writeObject(new T());

            oi = new ObjectInputStream(new FileInputStream("test.txt"));
            System.out.println(oi.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                oi.close();
                oo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 标记性接口  给编译器看的
 * @author 80959
 */
class T implements Serializable{
    /**
     * transient 透明的 不序列化它
     */
    int i1 = 10;
    transient String s = "i am a string";
    long l1 = 10L;

    @Override
    public String toString() {
        return "T{" +
                "i1=" + i1 +
                ", s='" + s + '\'' +
                ", l1=" + l1 +
                '}';
    }
}
