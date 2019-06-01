package com.huo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author huoyun
 * @date 2019/6/1-17:28
 */
public class TestInputStream {
    public static void main(String[] args) throws InterruptedException, IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream("D:\\devlop\\代码\\java重点\\IO\\src\\com\\huo\\io\\TestInputStream.java");
        } catch (FileNotFoundException e) {
            System.out.println("没有读到文件");
            System.exit(-1);
        }
        try {
            while (true) {
                int b = in.read();
                if (b == -1) {
                    break;
                }
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.close();
        System.out.println();
        try {
            in = new FileInputStream("D:\\devlop\\代码\\java重点\\IO\\IO.iml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("没有读到文件");
            System.exit(-1);
        }

        try {
            while (true) {
                int b = in.read();
                if (b == -1) {
                    break;
                }
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
