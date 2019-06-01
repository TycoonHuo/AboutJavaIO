package com.huo.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * 打印留
 * @author huoyun
 * @date 2019/6/1-21:33
 */
public class TestPrintStream {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            ps = new PrintStream("test1.txt");
            System.setOut(ps);
            System.out.println(new Date());
            System.out.println("打飞机");
            ps.println("打印流太爽了");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            ps.close();
        }
    }
}
