package com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description CyclicBarrier 可多次
 * 重点 解决主线程在子线程之前执行的问题
 * CyclicBarrier自身并不保证主线程在子线程完成之后执行
 * CyclicBarrier仅仅是为调用await方法的线程设置一个集合点
 * 问题解决: 配合使用CountDownLatch
 * @Author nya
 * @Date 2020/6/30 上午11:59
 **/
public class CheckCyclicBarrier {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CheckCyclicBarrier barrier = new CheckCyclicBarrier();
        List<Integer> test = barrier.test();
        System.out.println("result --------- ");
        System.out.println("heiheihei ----" + test);
    }

    List<Integer> test() throws InterruptedException {
        int count = 5;
        List<Integer> res = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(count);
        new Thread(()-> {

        }).start();

        CyclicBarrier barrier = new CyclicBarrier(count, () -> System.out.println(res));

        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 1 ; i <= count;i++) {
            exec.submit(new BarrierThread(barrier,10,100,1000,10000, res,i,latch));
        }
        exec.shutdown();
        latch.await();
        System.out.println(res);
        return res;
    }


    static class BarrierThread extends Thread {
        private CyclicBarrier barrier;
        private int firstLayer;
        private int secondLayer;
        private int thirdLayer;
        private int fourthLayer;
        private List<Integer> list;
        private int sign;
        private CountDownLatch latch;

        public BarrierThread(CyclicBarrier barrier, int firstLayer, int secondLayer, int thirdLayer, int fourthLayer, List<Integer> list,int sign,CountDownLatch latch) {
            this.barrier = barrier;
            this.firstLayer = firstLayer;
            this.secondLayer = secondLayer;
            this.thirdLayer = thirdLayer;
            this.fourthLayer = fourthLayer;
            this.sign = sign;
            this.list = list;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println(sign + " - " + firstLayer);
                list.add(sign + firstLayer);
                barrier.await();
                System.out.println(sign + " - " + secondLayer);
                list.add(sign + secondLayer);
                barrier.await();
                System.out.println(sign + " - " + thirdLayer);
                list.add(sign + thirdLayer);
                barrier.await();
                System.out.println(sign + " - " + fourthLayer);
                list.add(sign + fourthLayer);
                barrier.await();
                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
