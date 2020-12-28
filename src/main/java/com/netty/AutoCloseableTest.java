package com.netty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description 测试流的自动关闭
 * @Author nya
 * @Date 2020/8/26 上午9:48
 **/
public class AutoCloseableTest {

    public static void main(String[] args) {
        // JDK 1.7 新特性,AutoCloseable 接口
        try(BufferedReader br = new BufferedReader(new FileReader("/home/lab/1.txt"))) {
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("released");
        }

    }

}
