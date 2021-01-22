package com.test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/7/29 下午7:11
 **/
public class BatchDownloadFile {

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("/home/lab/video-tag.log"));
            int i = 1;
            while (true) {
                String url = bf.readLine();
                long a = System.currentTimeMillis();
                downloadByUrl(url,i);
                long b = System.currentTimeMillis();
                System.out.println(i + " --- " + url + " --- " + Math.round((b-a)/1000) + " ms");
                i++;
//                if (i > 38408 && i <= 120000) {
//                    long a = System.currentTimeMillis();
//                    downloadByUrl(url);
//                    long b = System.currentTimeMillis();
//                    System.out.println(i + " --- " + url + " --- " + Math.round((b-a)/1000) + " ms");
//                } else if (i > 120000) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String downloadByUrl(String item,int index) {
        File file = null;
        String path = "";
        try {
            if (StringUtils.isNotBlank(item)) {
                String[] strings = item.split("\t");
                String url = strings[1];
                String tag = strings[2];
                String tagItem = tag.replace(",", "-");
                URL remote = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) remote.openConnection();
                if (conn.getResponseCode() / 100 != 2) {
                    System.out.println("url connect timeout url:"+url);
                } else {
                    InputStream videoInputStream = conn.getInputStream();
                    file = new File("/data/test-video/" + tagItem.trim()+"-"+index + ".mp4");
                    FileUtils.copyInputStreamToFile(videoInputStream,file);
                    if (!file.exists()) {
                        System.out.println("url is illegal url:" + url);
                    } else {
                        path = file.getPath();
                    }
                }
                conn.disconnect();
            }
        } catch (Exception e) {
            if (file != null && file.exists()) {
                FileUtils.deleteQuietly(file);
            }
        }
        return path;
    }

    private static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        return str + rannum;// 当前时间
    }

}
