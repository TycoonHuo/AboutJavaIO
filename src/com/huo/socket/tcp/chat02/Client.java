package com.huo.socket.tcp.chat02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author huoyun
 * @date 2019/6/3-20:34
 */
public class Client {
    public static void main(String[] args) {
        Socket s = null;
        DataInputStream dips = null;
        DataOutputStream dops = null;

        try {
            s = new Socket("127.0.0.1",8888);

            dips = new DataInputStream(s.getInputStream());
            dops = new DataOutputStream(s.getOutputStream());

            dops.writeUTF("client>>>"+new BufferedReader(new InputStreamReader(System.in)).readLine());
            String s1;
            // 当没有接收到bye的时候 轮询
            while (!(s1 = dips.readUTF()).equals("server>>>bye")) {
                System.out.println(s1);
                dops.writeUTF("client>>>"+new BufferedReader(new InputStreamReader(System.in)).readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null && dips != null && dops != null) {
                    s.close();
                    dips.close();
                    dops.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
