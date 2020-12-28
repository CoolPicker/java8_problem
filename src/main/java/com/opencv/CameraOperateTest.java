package com.opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/6/30 下午3:34
 **/
public class CameraOperateTest {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    // 131-150 六楼 25-190
    private static final String rtspAddress = "rtsp://admin:hk123456@172.20.17.148:554/h264/ch1/main/av_stream";

    public static void main(String[] args) {
        String pre = "172.20.17.";
        AtomicInteger count = new AtomicInteger();
        String dirPre = "/home/lab/test/camera/";
        // 文件夹名
        String here = "l";

        String dirPath = dirPre + here + "/";
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        for (int i = 25; i <= 190; i++) {
            if (i == 41
                    || i == 56
                    || i == 57
                    || i == 58
                    || i == 59
                    || i == 60
                    || i == 61
                    || i == 72
                    || i == 93
                    || i == 128
                    || i == 129
                    || i == 130
                    || i == 157
                    || i == 167
                    || i == 174
                    || i == 175
                    || i == 176
                    || i == 177
                    || i == 178
                    || i == 179
                    || i == 181
                    || i == 182
                    || i == 183
                    || i == 184
                    || i == 185
                    || i == 186
                    || i == 187 // 摄像头密码修改
                    || i == 188
                    || i == 189) continue;
            int finalI = i;
            int all = count.incrementAndGet();
            System.out.println("total add ... " + all);
            new Thread(() -> {
                VideoCapture capture = new VideoCapture();
                try {
                    String rtspAddress = getRtspAddress(pre + finalI);
                    capture.open(rtspAddress);
                    while (capture.isOpened()) {
                        Mat frame = new Mat();
                        try {
                            boolean read = capture.read(frame);
                            if (read) {
                                System.out.println(finalI + "  - - height : " + frame.rows() + " width : " + frame.cols());
                                Imgcodecs.imwrite( dirPath+ finalI + ".jpg",frame);
                                int then = count.decrementAndGet();
                                System.out.println("remain ... " + then);
                                break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            frame.release();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    capture.release();
                }
            }).start();

        }
    }

    void testFrameSave() {
        VideoCapture capture = new VideoCapture();
        String ip = "172.20.17.149";
        String pre = "172.20.17";
        capture.open(getRtspAddress(ip));
        while (capture.isOpened()) {
            Mat frame = new Mat();
            try {
                Thread.sleep(200);
                boolean read = capture.read(frame);
                if (read) {
                    System.out.println("height : " + frame.rows() + " width : " + frame.cols());
                    Imgcodecs.imwrite("/home/lab/test/camera/" + System.currentTimeMillis() + ".jpg",frame);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                frame.release();
            }
        }
        capture.release();
    }

    static String getRtspAddress(String ip){
        String userName = "admin";
        String password = "hk123456";
//        String IP = "172.20.17.148";
        String port = "554";
        String codec = "h264";
        String channel = "ch1";
        String subtype = "main";
        return "rtsp://" + userName
                + ":" + password
                + "@" + ip
                + ":" + port
                + "/" + codec
                + "/" + channel
                + "/" + subtype
                + "/av_stream";
    }

}
