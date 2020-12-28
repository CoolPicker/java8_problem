package com.netty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description SocketChannel 服务端
 * @Author nya
 * @Date 2020/8/4 上午11:55
 **/
public class ServerSocketChannelServer {

    private static int port = 28098;
    private ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
    // 使用Map保存每个连接，当OP_READ就绪时，根据key找到对应的文件对其进行写入。
    // 若将其封装成一个类，作为值保存，可以在上传过程中显示进度等等
    Map<SelectionKey, FileChannel> fileMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        ServerSocketChannelServer server = new ServerSocketChannelServer();
        server.startServer();
    }

    void startServer() throws IOException{
        // 1. 获取通道管理器
        Selector selector = Selector.open();
        // 2. 获取一个ServerSocket通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // 3. 设置为非阻塞
        serverChannel.configureBlocking(false);
        // 4. 绑定监听,配置TCP参数
        serverChannel.bind(new InetSocketAddress(port));
        // 4. 将通道管理器与通道绑定,并为该通道注册SelectionKey.OP_ACCEPT事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器已开启...");
        // 5. 自旋 检测连接
        while (true) {
            // 当有注册的事件到达时, 接收, 否则返回0
            int num = selector.select();
            if (num == 0) continue;
            // 获取selector中的迭代器，选中项为注册的事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    // 获取客户端连接通道
                    SocketChannel socketChannel = channel.accept();
                    if (socketChannel == null) continue;
                    // 可以在任意位置调用这个方法
                    // 新的阻塞模式只会影响当前的IO操作
                    socketChannel.configureBlocking(false);
                    // 读取客户端上传
                    SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
                    // 获取客户端连接信息
                    InetSocketAddress remoteAddress = (InetSocketAddress)socketChannel.getRemoteAddress();
                    // 新建接收文件
                    File file = new File("/home/lab/Desktop/" + remoteAddress.getHostName() + "_" + remoteAddress.getPort() + ".pdf");
                    FileChannel fileChannel = new FileOutputStream(file).getChannel();
                    fileMap.put(selectionKey, fileChannel);
                    System.out.println(socketChannel.getRemoteAddress() + "连接成功...");
                    writeToClient(socketChannel);
                }
                else if (key.isReadable()){
                    readData(key);
                }
                // NIO的特点只会累加
                // 已选择的键的集合不会删除
                // ready集合会被清空
                // 只是临时删除已选择键集合
                // 当该键代表的通道上再次有感兴趣的集合准备好之后
                // 又会被select函数选中
                // 此处删除已选的key, 避免重复处理
                it.remove();
            }
        }
    }
    private void writeToClient(SocketChannel socketChannel) throws IOException {
        buffer.clear();
        buffer.put((socketChannel.getRemoteAddress() + "连接成功").getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();
    }
    private void readData(SelectionKey key) throws IOException  {
        FileChannel fileChannel = fileMap.get(key);
        buffer.clear();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int num;
        try {
            while ((num = socketChannel.read(buffer)) > 0) {
                buffer.flip();
                // 写入文件
                fileChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            key.cancel();
            e.printStackTrace();
            return;
        }
        // 调用close为-1 到达末尾
        if (num == -1) {
            fileChannel.close();
            System.out.println("上传完毕");
            buffer.put((socketChannel.getRemoteAddress() + "上传成功").getBytes());
            buffer.clear();
            socketChannel.write(buffer);
            key.cancel();
        }
    }

}
