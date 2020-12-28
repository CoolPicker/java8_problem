package com.leetcode;

import org.apache.commons.collections4.ListUtils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @Description
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @Author nya
 * @Date 2020/7/13 上午10:47
 **/
public class IntersectArrays350 {

    public static void main(String[] args) throws Exception {
//        int[] aa = {1,2,3,2,4};
//        int[] bb = {2,2,3};
//        IntersectArrays350 intersect = new IntersectArrays350();
//        int[] intersect1 = intersect.intersect(aa, bb);
//        for (int i = 0; i < intersect1.length; i++) {
//            System.out.println(intersect1[i]);
//        }
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        BufferedReader br = new BufferedReader(new FileReader("/home/lab/1.txt"));
        AtomicInteger i = new AtomicInteger(1);
        br.lines().forEach(item -> {
            VideoCapture capture = new VideoCapture(item);
            Mat frame = new Mat();
            capture.read(frame);
            Imgcodecs.imwrite("/home/lab/test/camera/" + i.getAndIncrement() + ".jpg",frame);
            frame.release();
            capture.release();
        });

//        VideoCapture capture = new VideoCapture("http://smallmv.eastday.com/mv/20200710164905413054999_1.mp4");
//
//        Double frameCount = capture.get(Videoio.CV_CAP_PROP_FRAME_COUNT); //总帧数
//        for (int i = 0; i < frameCount; i++){
//            Mat frame = new Mat();
//            capture.read(frame);
//            Imgcodecs.imwrite("/home/lab/test/camera/" + i + ".jpg",frame);
//            frame.release();
//        }
//        capture.release();
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> arrayList = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        // 做了去重
        List<Integer> intersection = ListUtils.intersection(list, arrayList);
        System.out.println(intersection);
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

}
