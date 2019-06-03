package com.huo.socket.tcp.chat02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 点对点的 你说一句我说一句
 *
 * @author huoyun
 * @date 2019/6/3-20:26
 */
public class Server {
    public static void main(String[] args) {
        Socket s = null;
        DataInputStream dips = null;
        DataOutputStream dops = null;
        try {
            ServerSocket ss = new ServerSocket(8888);
            s = ss.accept();
            System.out.println(s);

            dips = new DataInputStream(s.getInputStream());
            dops = new DataOutputStream(s.getOutputStream());

            String s1;

            // 当没有接收到bye的时候 轮询
            while (!(s1=dips.readUTF()).equals("client>>>bye")) {
                System.out.println(s1);
                dops.writeUTF("server>>>"+new BufferedReader(new InputStreamReader(System.in)).readLine());
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
