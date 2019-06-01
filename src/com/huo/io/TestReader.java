package com.huo.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author huoyun
 * @date 2019/6/1-18:21
 */
public class TestReader {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("test.txt");
            while (true) {
                int b = fileReader.read();
                if (b == -1) {
                    break;
                }
                System.out.print((char) b);
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
