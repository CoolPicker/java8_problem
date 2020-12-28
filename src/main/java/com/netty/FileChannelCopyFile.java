package com.netty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

/**
 * @Description 使用FileChannel复制文件
 * @Author nya
 * @Date 2020/8/4 上午11:09
 **/
public class FileChannelCopyFile {

    public static void main(String[] args) {
        channelTransferTo();
        nioCopy();
        channelTransferFrom();
    }

    /**
     * transferFrom方法的使用
     */
    private static void channelTransferFrom(){
        File source = new File("/home/lab/Desktop/OpenCV.pdf");
        File target = new File("/home/lab/Desktop/OpenCV-3.pdf");
        try {

            FileChannel sourceChannel = new FileInputStream(source).getChannel();
            FileChannel destChannel = new FileOutputStream(target).getChannel();

            destChannel.transferFrom(sourceChannel,0,sourceChannel.size());

            sourceChannel.close();
            destChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * NIO通道拷贝文件,原生写法
     */
    private static void nioCopy(){
        File source = new File("/home/lab/Desktop/OpenCV.pdf");
        File target = new File("/home/lab/Desktop/OpenCV-2.pdf");

        try {
            // 创建空文件
            target.createNewFile();
            FileChannel channel = FileChannel.open(source.toPath());
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            // 创建通道
            FileChannel write = FileChannel.open(target.toPath(), StandardOpenOption.WRITE);
            while (channel.read(byteBuffer) != -1) {
                // 由读改为写
                byteBuffer.flip();
                write.write(byteBuffer);
                // 清空缓存区
                byteBuffer.clear();
            }
            channel.close();
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * fileChannel transferTo 使用
     */
    private static void channelTransferTo(){
        File source = new File("/home/lab/Desktop/OpenCV.pdf");
        File target = new File("/home/lab/Desktop/OpenCV-1.pdf");

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        FileChannel input = null;
        FileChannel output = null;
        try {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(target);
            input = inputStream.getChannel();
            output = outputStream.getChannel();
            input.transferTo(0,input.size(),output);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
