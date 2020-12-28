package com.leetcode;

/**
 * @Description TODO
 * @Author nya
 * @Date 2020/7/3 下午5:51
 **/
public class CalThirdSum {

    public static void main(String[] args) {
        // Optional<Integer> optional = Optional.of(5);
        // System.out.println(optional.isPresent());
        // System.out.println(optional.get());

        // String res = calThird(-100, 100, 29);
        // System.out.println(res);

        long a = 1000l;
        long b = 3333l;
        int round = Math.round(b / a);
        System.out.println(round);
    }

    static String calThird(int left,int right,int goal) {
        long count = 0;
        String res = "";
        for (int i = left; i <= right;i++) {
            for (int j = left + 1; j <= right;j++) {
                for (int k = j + 1; k <= right; k++) {
                    long first = (long)Math.pow(i, 3);
                    long second = (long)Math.pow(j,3);
                    long third = (long) Math.pow(k,3);
                    long sum = first + second + third;
                    System.out.println(count++);
                    if (goal == sum) {
                        res = i + " - " + j + " - " + k;
                        break;
                    }
                }
            }
        }
        return res;
    }

}
