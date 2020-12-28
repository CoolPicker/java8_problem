package com.concurrent;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description CountDownLatch 测试
 * @Author nya
 * @Date 2020/6/30 上午11:05
 **/
public class CheckCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        int count = 8;
        List<Integer> list = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < 8;i++) {
            SleepThread sleepThread = new SleepThread(1, i, latch, list);
            sleepThread.start();
        }
        System.out.println(list);
        latch.await();
        System.out.println(list);
        System.out.println(watch.getTime());
        watch.stop();
    }

    static class SleepThread extends Thread {
        private int time;
        private int sign;
        private CountDownLatch latch;
        private List<Integer> list;
        public SleepThread(int time,int sign,CountDownLatch latch,List<Integer> list) {
            this.time = time;
            this.sign = sign;
            this.latch = latch;
            this.list = list;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(time);
                System.out.println("sign: " + sign);
                list.add(sign);
                latch.countDown();
                // 注意
                // latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
