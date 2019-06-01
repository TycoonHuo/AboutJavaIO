package com.huo.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author huoyun
 * @date 2019/6/1-18:30
 */
public class TestWriter {
    public static void main(String[] args) {
        FileWriter wf = null;
        try {
            wf = new FileWriter("test.txt");
            for (int i = 0; i < 65535; i++) {
                wf.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                wf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
