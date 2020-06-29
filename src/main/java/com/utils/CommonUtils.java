package com.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/4/8 上午10:09
 **/
public class CommonUtils {

    /**
     * 根据url下载pic
     */
    public static void downloadPicture(String url,String path) {
        try {
            URL remote = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) remote.openConnection();
            if (conn.getResponseCode() / 100 != 2) {
                System.out.println("url is broken");
            } else {
                InputStream videoInputStream = conn.getInputStream();
                File file = new File(path);
                FileUtils.copyInputStreamToFile(videoInputStream,file);
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
