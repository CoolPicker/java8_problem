package com.leetcode;

/**
 * @Description
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * [-3,4,3,90]
 * 0
 *
 * [-10,-1,-18,-19]
 * -19
 * @Author nya
 * @Date 2020/6/29 上午11:16
 **/
public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length;i++) {
            for (int j = i + 1; j < nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    if (i < j) {
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-1,-18,-19};
        int target = -19;
        TwoSum1 sum = new TwoSum1();
        int[] ints = sum.twoSum(nums, target);
        System.out.println(ints[0] + " - " + ints[1]);
    }
}
