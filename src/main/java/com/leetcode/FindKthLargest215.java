package com.leetcode;

/**
 * @Description
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @Author nya
 * @Date 2020/6/29 上午11:00
 **/
public class FindKthLargest215 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        FindKthLargest215 largest = new FindKthLargest215();
        int largestKthLargest = largest.findKthLargest(nums, k);
        System.out.println(largestKthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        nums = bubbleSort(nums);
        return nums[nums.length - k];
    }

    public int[] bubbleSort(int[] nums) {
        for (int i = 0 ; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }




}
