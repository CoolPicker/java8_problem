package com.algorithm;

/**
 * @Description
 *  求2的开方
 * @Author nya
 * @Date 2019/11/19 下午2:10
 **/
public class SqrtTest {

    static final double EPSILON = 0.0000000001;
    static double sqrt2(){
        double low = 1.4;
        double high = 1.5;
        double mid = (low + high) / 2;
        while (high - low > EPSILON) {
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (high + low) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(sqrt2());
    }

}
