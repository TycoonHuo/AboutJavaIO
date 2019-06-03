package com.huo.socket.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * 起了一个线程 负责 轮询 dips这个管道
 *
 * @author huoguangyao
 * @date 2019/6/3 14:53
 */
public class Client {

    private Socket socket = null;
    private DataInputStream dips = null;


    private void clientRun() {
        try {
            // 一个socket 就是一个端到端通信的 一个端点
            socket = new Socket("127.0.0.1", 8888);
            DataOutputStream dops = new DataOutputStream(socket.getOutputStream());
            dips = new DataInputStream(socket.getInputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String s = dips.readUTF();
                        System.out.println(s + new Date());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            while (true) {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                dops.writeUTF("client:" + br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client().clientRun();
    }
}
