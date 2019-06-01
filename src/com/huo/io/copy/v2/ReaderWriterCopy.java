package com.huo.io.copy.v2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 用字符流来copy
 *
 * @author huoyun
 * @date 2019/6/1-18:37
 */
public class ReaderWriterCopy {
    public static void main(String[] args) {
        copy("D:\\devlop\\代码\\java重点\\IO\\src\\com\\huo\\io\\TestInputStream.java", "copytemp.java");
    }

    static void copy(String inPath, String outPath) {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(inPath);
            fw = new FileWriter(outPath);

            while (true) {
                int b = fr.read();
                if (b == -1) {
                    break;
                }
                fw.write(b);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
