package com.huo.io.copy.v1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用字节流来实现拷贝 没有使用buffer 现在这种写法 读一次硬盘只读一个字节
 *
 * @author huoyun
 * @date 2019/6/1-18:10
 */
public class InputOutputStream {
    public static void main(String[] args) {
        copy("D:\\devlop\\代码\\java重点\\IO\\src\\com\\huo\\io\\TestInputStream.java","copytemp.java");
    }

    static void copy(String inPath, String outPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(inPath);
            fos = new FileOutputStream(outPath);

            while (true) {
                int b = fis.read();
                fos.write(b);
                if (b == -1) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null && fos != null) {
                try {
                    fis.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
