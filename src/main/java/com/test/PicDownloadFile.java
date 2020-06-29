package com.test;

import com.utils.CommonUtils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/4/8 上午10:12
 **/
public class PicDownloadFile {

    public static void main(String[] args) throws Exception {
        String dirPath = "/home/lab/test/2/";

        BufferedReader br = new BufferedReader(new FileReader("/home/lab/order.txt"));

        br.lines().forEach(e -> {
            String[] split = e.split("\t");
            String name = split[1];
            String time = split[3];
            String url = split[4];

            String fileName = dirPath + time + "_" + name + ".jpg";
            System.out.println(fileName);
            System.out.println(url);

            CommonUtils.downloadPicture(url,fileName);
        });
        br.close();
    }


}
