package com.huo.socket.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * udp 没有server client一说  这里是为了掩饰
 *
 * @author huoyun
 * @date 2019/6/3-21:05
 */
public class UdpServer {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024];
        // 数据报包既能收数据也能发送数据
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        DatagramSocket ds = null;

        try {
            // DatagramSocket既能接受 也能发送
            ds = new DatagramSocket(8888);
            ds.receive(dp);

            System.out.println(new DataInputStream(new ByteArrayInputStream(bytes)).readLong());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }
}
