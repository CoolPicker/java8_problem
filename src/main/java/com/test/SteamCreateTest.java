package com.test;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * @Description Stream流 文件/字符串
 * @Author nya
 * @Date 2020/4/7 下午5:14
 **/
public class SteamCreateTest {


    public static void main(String[] args) throws Exception {
        AtomicInteger integer = new AtomicInteger(10000);

        // 文件转Stream
        BufferedReader br = new BufferedReader(new FileReader("/home/lab/2.txt"));
        String asyncProcess = br.lines().filter(StringUtils::isNotBlank).filter(e -> StringUtils.contains(e, "AsyncProcess")).findFirst().get();
        System.out.println(asyncProcess);
        // 字符串转Stream
        Pattern pattern = Pattern.compile("");
        pattern.splitAsStream(asyncProcess).filter(e -> Character.isUpperCase(e.charAt(0))).forEach(System.out::println);
        br.close();
        // IO 流 写   BufferedReader - 读流 BufferedWriter - 写流
        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/lab/1.txt"));
        bw.write("aaa");
        bw.newLine();
        bw.flush();
        bw.close();
        bw.write("bbb");
        bw.newLine();
        bw.flush();
        bw.write("ccc");
        bw.close();
    }

}
