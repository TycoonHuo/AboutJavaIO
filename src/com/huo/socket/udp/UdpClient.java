package com.huo.socket.udp;

import javax.xml.crypto.Data;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 体会ByteArray流的重要性
 * UDP 写一个long类型的数出去
 *
 * @author huoyun
 * @date 2019/6/3-20:53
 */
public class UdpClient {
    public static void main(String[] args) {
        byte[] bytes = null;
        DataOutputStream dops = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        dops = new DataOutputStream(baos);
        try {
            dops.writeLong(100L);
            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, new InetSocketAddress("127.0.0.1", 8888));

        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(5678);
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }
}
