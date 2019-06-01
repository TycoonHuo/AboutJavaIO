package com.huo.io;

import java.io.*;

/**
 * 数据流
 * 例如把一个long类型的写进去
 *
 * @author huoyun
 * @date 2019/6/1-21:02
 */
public class TestDataStream {
    public static void main(String[] args) {
        OutputStream ops = new ByteArrayOutputStream();
        DataOutputStream dops = new DataOutputStream(ops);

        try {
            dops.writeLong(123123123123123L);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(((ByteArrayOutputStream) ops).toByteArray()));

        try {
            System.out.println(dis.available());
            System.out.println(dis.readBoolean());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
                dops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
