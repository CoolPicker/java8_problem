package com.cpp;

/**
 * 计算1w以内的素数
 */
public class MathTest {

    public static void main(String[] args) {

        int count = 0;
        for (int i = 2 ; i < 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i/2 + 1; j++) {
                if (i % j == 0) {
//                    System.out.println(i + " ---- ( " + j + " * " + (i/j) + " )");
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("prime >>>> " + i);
                count++;
            }
        }

        System.out.println("prime size : " + count);
    }


}
