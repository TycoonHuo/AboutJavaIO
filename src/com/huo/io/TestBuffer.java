package com.huo.io;

import java.io.*;

/**
 * 处理流-缓冲流
 *
 * @author huoyun
 * @date 2019/6/1-19:29
 */
public class TestBuffer {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("D:\\devlop\\代码\\java重点\\IO\\test.txt"));
            while (true) {
                int b = bis.read();
                if (b == -1) {
                    break;
                }
                System.out.print((char) b);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
