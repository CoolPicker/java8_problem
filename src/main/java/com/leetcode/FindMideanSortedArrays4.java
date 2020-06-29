package com.leetcode;

import java.util.Arrays;

/**
 * @Description
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @Author nya
 * @Date 2020/6/29 下午2:25
 **/
public class FindMideanSortedArrays4 {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        FindMideanSortedArrays4 find = new FindMideanSortedArrays4();
        double median = find.findMedianSortedArrays(a, b);
        System.out.println(median);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res;
        int[] mm = new int[nums1.length + nums2.length];
        for (int i = 0; i < mm.length;i++) {
            if (i >= nums1.length) {
                mm[i] = nums2[i - nums1.length];
            } else {
                mm[i] = nums1[i];
            }
        }

        Arrays.sort(mm);
        if (mm.length % 2 == 0) {
            res = (double) (mm[mm.length/2-1] + mm[mm.length/2]) / 2;
        } else {
            res = mm[(mm.length - 1)/2];
        }

        return res;
    }

}
