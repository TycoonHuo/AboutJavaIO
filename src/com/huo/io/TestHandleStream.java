package com.huo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 处理流
 * 把字节流转换成字符流
 * 一般再套一层缓冲流
 *
 * @author huoyun
 * @date 2019/6/1-20:27
 */
public class TestHandleStream {

    public static void main(String[] args) {
        // 字节流  这块是阻塞的  也叫同步的
        InputStream in = System.in;
        // 转换流  字节流-> 字符流
        InputStreamReader isr = new InputStreamReader(in);
        // 处理流  加了缓冲 有一个好用的接口 readling()
        BufferedReader bufferedReader = new BufferedReader(isr);

        String s = null;
        try {
            while (true) {
                s = bufferedReader.readLine();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
