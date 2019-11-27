package com.algorithm;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;

public class StopWatchGo {

    public static void main(String[] args) {
        int N = 100000;
        int[] a = new int[N];
        for (int i = 0; i< N; i++)
            a[i] = RandomUtils.nextInt(0,1000);
        StopWatch timer = new StopWatch();
        int res = 0;
        for (int e :
                a) {
            res += e;
        }
        double time = timer.elapsedTime();
        System.out.println(res + " sum " + time + " milliseconds ");
    }

    static class StopWatch{
        private final long start;
        public StopWatch(){
            start = System.currentTimeMillis();
        }
        public double elapsedTime(){
            long now = System.currentTimeMillis();
            return now - start;
        }
    }
}
