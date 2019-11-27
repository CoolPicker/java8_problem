package com.algorithm;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class VideoToFrame {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        String path = "/home/lab/test/2/";
        VideoCapture capture = new VideoCapture("/home/lab/test/12121.mp4");
        Double frameCount = capture.get(Videoio.CV_CAP_PROP_FRAME_COUNT); //总帧数
        Double rawFps = capture.get(Videoio.CV_CAP_PROP_FPS); //帧率
        System.out.println("frame count: " + frameCount + " ,fps: " + rawFps);
        for (int i=0; i<frameCount; i++) {
            Mat frame = new Mat();
            try {
                boolean read = capture.read(frame);
                if (read) {
                    Imgcodecs.imwrite(path + i + ".png", frame);
                } else {
                    frame.release();
                }
            } catch (Exception e) {
                frame.release();
            } finally {
                frame.release();
            }
        }
        capture.release();
    }

}
