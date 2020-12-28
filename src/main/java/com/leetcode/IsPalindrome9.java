package com.leetcode;

/**
 * @Description
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 * @Author nya
 * @Date 2020/7/29 下午2:41
 **/
public class IsPalindrome9 {

    public static void main(String[] args) {
        IsPalindrome9 palindrome = new IsPalindrome9();
        boolean stat = palindrome.isPalindrome2(-121);
        System.out.println(stat);
        System.out.println((long)Math.pow(2,32));
        System.out.println(Math.abs((long)Integer.MAX_VALUE) + Math.abs((long)Integer.MIN_VALUE) + 1);
    }

    public boolean isPalindrome2(int x) {
        String a = x + "";
        for (int i = 0; i <= a.length() / 2; i++){
            if (a.charAt(i) != a.charAt(a.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int start = 9;
        int index = 0;
        boolean status = true;
        double[] items = new double[0];
        while (start >= 0) {
            double floor = Math.floor(x / (Math.pow(10, start)));
            start--;
            if (status) {
                if (floor > 0) {
                    status = false;
                    items = new double[start+2];
                    x = (int)(x - floor * Math.pow(10,start+1));
                    items[index] = floor;
                    index++;
                    continue;
                } else {
                    continue;
                }
            }
            items[index] = floor;
            index++;
            x = (int)(x - floor * Math.pow(10,start+1));
        }
        for (int i = 0; i < items.length / 2; i++){
            double begin = items[i];
            double end = items[items.length - i - 1];
            if (begin != end) return false;
        }
        return true;
    }

}
