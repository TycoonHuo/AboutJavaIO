package com.huo.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author huoyun
 * @date 2019/6/1-20:11
 */
public class TestBufferReader {
    public static void main(String[] args) {
        BufferedReader br = null;


        try {
            br = new BufferedReader(new FileReader("D:\\devlop\\代码\\java重点\\IO\\test.txt"));
            String s = br.readLine();
            s = br.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
