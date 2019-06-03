package com.huo.socket.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * TCP的 server
 * 起了一个线程 负责 轮询 dips这个管道 监听别人发来的消息
 *
 * @author huoguangyao
 * @date 2019/6/3 14:42
 */
public class Server {

    private Socket socket = null;
    private DataInputStream dips = null;


    private void serverRun() {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("server start...");
            socket = ss.accept();
            dips = new DataInputStream(socket.getInputStream());
            DataOutputStream dops = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    try {
                        String s = dips.readUTF();
                        System.out.println(s + new Date());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();

            while (true) {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                dops.writeUTF("server:" + br.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().serverRun();
    }
}
