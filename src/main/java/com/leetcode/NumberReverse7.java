package com.leetcode;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/7/3 下午3:09
 **/
public class NumberReverse7 {

    public static void main(String[] args) {
        int a = 123;
        NumberReverse7 number = new NumberReverse7();
        int reverse = number.reverse(a);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        boolean start = false;
        int ten = 0;
        long res = 0l;
        for (int i = 9; i >= 0; i--) {
            int divisor = (int)(Math.pow(10,i));
            int divide = x / divisor;
            if (divide != 0) {
                x = x % (divide * divisor);
            }
            if (!start) {
                if (divide != 0) {
                    start = true;
                }
            }
            if (start) {
                res = res + (divide * ((long)Math.pow(10,ten)));
                ten++;
            }
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }
}
