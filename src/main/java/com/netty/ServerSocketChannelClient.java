package com.netty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @Description ServerSocket 客户端
 * @Author nya
 * @Date 2020/8/5 上午9:59
 **/
public class ServerSocketChannelClient {

    private static int port = 28098;
    private static String ip = "127.0.0.1";
    public static void main(String[] args) {
        ServerSocketChannelClient client = new ServerSocketChannelClient();
        client.clientSent();
    }

    void clientSent(){
        for (int i = 0; i < 3; i++) {
            // 模拟三个发送端
            new Thread(() -> {
                try {
                    SocketChannel socketChannel = SocketChannel.open();
                    socketChannel.socket().connect(new InetSocketAddress(ip, port));
                    File file = new File("/home/lab/Desktop/OpenCV.pdf");
                    FileChannel fileChannel = new FileInputStream(file).getChannel();
                    ByteBuffer buffer = ByteBuffer.allocate(100);
                    socketChannel.read(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, buffer.limit(), Charset.forName("utf-8")));
                    buffer.clear();
                    int num;
                    while ((num=fileChannel.read(buffer)) > 0) {
                        buffer.flip();
                        socketChannel.write(buffer);
                        buffer.clear();
                    }
                    if (num == -1) {
                        fileChannel.close();
                        socketChannel.shutdownOutput();
                    }
                    // 接受服务器
                    socketChannel.read(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, buffer.limit(), Charset.forName("utf-8")));
                    buffer.clear();
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.yield();
    }

}
